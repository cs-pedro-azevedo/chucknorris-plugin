package hudson.plugins.csvaicavalo;

import hudson.Extension;
import hudson.model.AbstractProject;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.Publisher;

@Extension
public class BeardDescriptor extends BuildStepDescriptor<Publisher> {

    /**
     * Constructs a {@link BeardDescriptor}.
     */
    public BeardDescriptor() {
        super(CordellWalkerRecorder.class);
    }

    /**
     * Gets the descriptor display name, used in the post step checkbox
     * description.
     * @return the descriptor display name
     */
    @Override
    public final String getDisplayName() {
        return "Activate Chuck Norris";
    }

    /**
     * Checks whether this descriptor is applicable.
     * @param clazz
     *            the class
     * @return true - of course the beard is applicable
     */
    @Override
    public final boolean isApplicable(
            final Class<? extends AbstractProject> clazz) {
        return true;
    }
}
