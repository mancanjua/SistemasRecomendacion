package pojos;

public enum Genre {
    ACTION, ADVENTURE, ANIMATION, CHILDREN, COMEDY, CRIME, DOCUMENTARY, DRAMA, FANTASY, FILM_NOIR, HORROR, IMAX, MUSICAL, MYSTERY, ROMANCE, SCI_FI, THRILLER, WAR, WESTERN, NON_GENRE_LISTED;

    public static Genre getValue(String s) {
        switch (s) {
            case "Action":
                return Genre.ACTION;
            case "Animation":
                return Genre.ANIMATION;
            case "Adventure":
                return Genre.ADVENTURE;
            case "Children":
                return Genre.CHILDREN;
            case "Comedy":
                return Genre.COMEDY;
            case "Crime":
                return Genre.CRIME;
            case "Documentary":
                return Genre.DOCUMENTARY;
            case "Drama":
                return Genre.DRAMA;
            case "Fantasy":
                return Genre.FANTASY;
            case "Film-Noir":
                return Genre.FILM_NOIR;
            case "Horror":
                return Genre.HORROR;
            case "IMAX":
                return Genre.IMAX;
            case "Mystery":
                return Genre.MYSTERY;
            case "Musical":
                return Genre.MUSICAL;
            case "Romance":
                return Genre.ROMANCE;
            case "Sci-Fi":
                return Genre.SCI_FI;
            case "Thriller":
                return Genre.THRILLER;
            case "War":
                return Genre.WAR;
            case "Western":
                return Genre.WESTERN;
            default:
                return Genre.NON_GENRE_LISTED;
        }
    }
}
