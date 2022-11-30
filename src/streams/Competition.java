package streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Competition {

    public static Map<String, Integer> getTeamPlaceMap(Collection<Team> teams) {
        return teams
                .stream()
                .sorted(Comparator.comparingInt(Team::getPlace))
                .collect(Collectors.toMap(
                        Team::getName,
                        Team::getPlace,
                        (x1,x2)->x1,LinkedHashMap::new
                        )
                );
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Collection<Team> teams = Stream
                .iterate(1, i -> scanner.hasNextLine(), i -> i + 1)
                .map(i -> scanner.nextLine().split("\\s+"))
                .map(parts -> new Team(parts[0], Integer.parseInt(parts[1])))
                .collect(Collectors.toSet());

        getTeamPlaceMap(teams)
                .forEach((team, speaker) -> System.out.println(team + ": " + speaker));
    }
}

class Team {
    private final String name;
    private final int place;

    public Team(String name, int place) {
        this.name = name;
        this.place = place;
    }

    public String getName() {
        return name;
    }

    public int getPlace() {
        return place;
    }
}