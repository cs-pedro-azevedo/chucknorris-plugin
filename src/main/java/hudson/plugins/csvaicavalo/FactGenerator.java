package hudson.plugins.csvaicavalo;

import java.util.Random;

/**
 * {@link FactGenerator} provides Chuck Norris facts.
 * @author cliffano
 */
public class FactGenerator {

    private static final String[] FACTS = {
            "PARA DE SER VIADO E ARRUMA ESSA PORRA!",
            "CARALHO MANO.. DEIXA DE SER BURRO!!",
            "VOCÊ É BURRO OU BURRO?!"};

    /**
     * Random instance.
     */
    private static final Random RANDOM = new Random();

    /**
     * Retrieves a random fact.
     * @return a random fact
     */
    public String random() {
        return FACTS[RANDOM.nextInt(FACTS.length)];
    }
}
