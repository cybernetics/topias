package handlers.ide;

import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.project.Project;
import git4idea.repo.GitRepository;
import git4idea.repo.GitRepositoryChangeListener;
import org.jetbrains.annotations.NotNull;
import processing.GitCommitsProcessor;

import static processing.Utils.buildDBUrlForSystem;

public class GitRepoChangeListener implements GitRepositoryChangeListener {
    @Override
    public void repositoryChanged(@NotNull GitRepository repository) {
        final Project project = repository.getProject();
        ProgressManager.getInstance().getProgressIndicator().isRunning();
        GitCommitsProcessor.processGitHistory(project, buildDBUrlForSystem(project), false);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();

    }
}
