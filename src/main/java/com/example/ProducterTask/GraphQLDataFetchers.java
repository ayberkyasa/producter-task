package com.example.ProducterTask;

import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.ProducterTask.Player.position;

import java.util.Optional;


@Component
public class GraphQLDataFetchers {
    private final int MAX_TEAM_CAPACITY = 12;
    private final PlayerRepository playerRepository;

    @Autowired
    public GraphQLDataFetchers(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public DataFetcher getPlayersDataFetcher() {
        return dataFetchingEnvironment -> {
            return playerRepository.findAll();
        };
    }

    public DataFetcher addPlayerDataFetcher() {
        return dataFetchingEnvironment -> {
            if(playerRepository.count() == MAX_TEAM_CAPACITY) {
                throw new IllegalStateException("Team has already been full!");
            }

            String name = dataFetchingEnvironment.getArgument("name");
            String surname = dataFetchingEnvironment.getArgument("surname");
            position position = Player.position.valueOf(dataFetchingEnvironment.getArgument("position"));
            if(playerRepository.findPlayerByNameAndSurname(name, surname).isPresent()) {
                throw new IllegalStateException("This player has already been existed!");
            }

            if(name != null && name.length() > 0 && surname != null & surname.length() > 0) {
                Player player = new Player(name,surname,position);
                return playerRepository.save(player).getId();
            }

            throw new IllegalArgumentException("Inputs are not valid!");
        };
    }

    public DataFetcher deletePlayerDataFetcher() {
        return dataFetchingEnvironment -> {
            if(playerRepository.count() == 0) {
                throw new IllegalStateException("Team has already been empty!");
            }

            Integer id = Integer.parseInt(dataFetchingEnvironment.getArgument("id"));
            if(!playerRepository.existsById(id)) {
                throw new IllegalArgumentException("There is no such a player in this team!");
            }
            Optional<Player> player = playerRepository.findById(id);
            playerRepository.deleteById(id);
            return player;
        };
    }

}
