package hexagonal.architecture.esdras.domain.vo;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public record RankingIdentityDomain(String value) {
    public static final String ALPHABET = "23456789ABCDEFGHJKLMNPQRSTUVWXYZ";

    public static final String RANKING = "RANKING";
    public static final int LENGTH_OF_RANDOM_PART = 10;

    public RankingIdentityDomain {
        Objects.requireNonNull(value, "'value' cannot be null");
        if (value.isEmpty()) {
            throw new IllegalArgumentException("'value' cannot be empty");
        }
    }

    public static RankingIdentityDomain generateRandomPart() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        char[] chars = new char[LENGTH_OF_RANDOM_PART];
        for (int i = 0; i < LENGTH_OF_RANDOM_PART; i++) {
            chars[i] = ALPHABET.charAt(random.nextInt(ALPHABET.length()));
        }
        return new RankingIdentityDomain(RANKING + new String(chars));
    }


}
