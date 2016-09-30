package hudson.plugins.csvaicavalo;

import hudson.Launcher;
import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;
import hudson.model.Action;
import hudson.model.BuildListener;
import hudson.tasks.BuildStepMonitor;
import hudson.tasks.Recorder;

import java.io.IOException;
import java.util.logging.Logger;

import org.kohsuke.stapler.DataBoundConstructor;

/**
 * This class associates a RoundhouseAction to a job or a build. For more info
 * on Cordell Walker, check out <a
 * href="http://www.imdb.com/character/ch0038386/"
 * >http://www.imdb.com/character/ch0038386/</a>.
 * @author cliffano
 */
public class CordellWalkerRecorder extends Recorder {

    /**
     * Logger.
     */
    private static final Logger LOGGER = Logger
            .getLogger(CordellWalkerRecorder.class.getName());

    /**
     * Fact generator.
     */
    private FactGenerator factGenerator;

    /**
     * Constructs a {@link CordellWalkerRecorder} with default
     * {@link FactGenerator}.
     */
    @DataBoundConstructor
    public CordellWalkerRecorder() {
        this(new FactGenerator());
    }

    /**
     * Constructs a {@link CordellWalkerRecorder} with specified
     * {@link FactGenerator}.
     * @param factGenerator
     *            the fact generator
     */
    public CordellWalkerRecorder(final FactGenerator factGenerator) {
        this.factGenerator = factGenerator;
        LOGGER.info("Chuck Norris is activated");
    }

    /**
     * Gets the RoundhouseAction as the project action. This is applicable for
     * each job and only when there's at least one build in the job.
     * @param project
     *            the project
     * @return the project action
     */
    @Override
    public final Action getProjectAction(final AbstractProject<?, ?> project) {
        Action action = null;
        if (project.getLastBuild() != null) {
            Style style = Style.get(project.getLastBuild().getResult());
            String fact = factGenerator.random();
            action = new RoundhouseAction(style, fact);
        }
        return action;
    }

    /**
     * Adds RoundhouseAction to the build actions. This is applicable for each
     * build.
     * @param build
     *            the build
     * @param launcher
     *            the launcher
     * @param listener
     *            the listener
     * @return true
     * @throws InterruptedException
     *             when there's an interruption
     * @throws IOException
     *             when there's an IO error
     */
    @Override
    public final boolean perform(final AbstractBuild<?, ?> build,
            final Launcher launcher, final BuildListener listener)
            throws InterruptedException, IOException {
        Style style = Style.get(build.getResult());
        String fact = factGenerator.random();
        build.getActions().add(new RoundhouseAction(style, fact));
        return true;
    }

    /**
     * Gets the required monitor service.
     * @return the BuildStepMonitor
     */
    public final BuildStepMonitor getRequiredMonitorService() {
        return BuildStepMonitor.NONE;
    }
}
