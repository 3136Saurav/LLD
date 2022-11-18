import java.util.*;

public class Main {

    public static void main(String[] args) {

        Directory movieDirectory = new Directory("movies");
        FileSystem border = new File("border.mov");
        Directory comedyMovieDirectory = new Directory("comedy-movies");
        FileSystem seventeenAgain = new File("17again.mov");
        comedyMovieDirectory.add(seventeenAgain);

        movieDirectory.add(border);
        movieDirectory.add(comedyMovieDirectory);

        movieDirectory.ls();
    }


}
