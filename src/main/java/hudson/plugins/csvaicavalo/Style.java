package hudson.plugins.csvaicavalo;

import hudson.model.Result;

/**
 * This class provides various Chuck Norris' styles.
 * @author cliffano
 */
public enum Style {

    /**
     * A happy Chuck Norris showing a thumb up.
     */
    THUMB_UP,
    /**
     * An alert Chuck Norris with a martial arts stance.
     */
    ALERT,
    /**
     * A total bad ass Chuck Norris ready to give you a good ass whoopin'.
     */
    BAD_ASS;

    /**
     * Gets the style corresponding to the build result.
     * @param result
     *            the build result
     * @return the style
     */
    public static final Style get(final Result result) {
        Style style;
        if (Result.FAILURE.equals(result)) {
            style = BAD_ASS;
        } else if (Result.SUCCESS.equals(result)) {
            style = THUMB_UP;
        } else {
            style = ALERT;
        }
        return style;
    }
}
