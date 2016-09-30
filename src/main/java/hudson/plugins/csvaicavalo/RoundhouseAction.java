package hudson.plugins.csvaicavalo;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import hudson.model.Action;

/**
 * {@link RoundhouseAction} keeps the style and fact associated with the action.
 * For more info, please watch <a
 * href="http://www.youtube.com/watch?v=Vb7lnpk3tRY"
 * >http://www.youtube.com/watch?v=Vb7lnpk3tRY</a>
 * @author cliffano
 */
public final class RoundhouseAction implements Action {

    /**
     * The style - for backward compatibility to version 0.2.
     */
    private Style style;
    
    /**
     * The style.
     */
    private Style mStyle;

    /**
     * The fact - for backward compatibility to version 0.2.
     */
    private String fact;
    
    /**
     * The fact.
     */
    private String mFact;

    /**
     * Constructs a RoundhouseAction with specified style and fact.
     * @param style
     *            the style
     * @param fact
     *            the fact
     */
    public RoundhouseAction(final Style style, final String fact) {
        super();
        this.mStyle = style;
        this.mFact = fact;
    }

    /**
     * Gets the action display name.
     * @return the display name
     */
    public String getDisplayName() {
        return "Chuck Norris";
    }

    /**
     * This action doesn't provide any icon file.
     * @return null
     */
    public String getIconFileName() {
        return null;
    }

    /**
     * Gets the URL name for this action.
     * @return the URL name
     */
    public String getUrlName() {
        return "chucknorris";
    }

    /**
     * Gets the Chuck Norris style.
     * @return the style
     */
    // TODO : check infra statistics to see if someone still has chucknorris in 0.2...
    @SuppressFBWarnings(value = "UWF_UNWRITTEN_FIELD", justification = "that field could have been deserialized from old <= 0.2")
    public Style getStyle() {
        Style theStyle;
        if (mStyle != null) {
            theStyle = mStyle;
        } else {
            theStyle = style;
        }
        return theStyle;
    }

    /**
     * Gets the Chuck Norris fact.
     * @return the fact
     */
    @SuppressFBWarnings(value = "UWF_UNWRITTEN_FIELD", justification = "that field could have been deserialized from old <= 0.2")
    public String getFact() {
        String theFact;
        if (mFact != null) {
            theFact = mFact;
        } else {
            theFact = fact;
        }
        return theFact;
    }
}
