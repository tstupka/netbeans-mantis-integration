
package eu.doppel_helix.netbeans.mantisintegration.repository;

import eu.doppel_helix.netbeans.mantisintegration.issue.MantisIssue;
import eu.doppel_helix.netbeans.mantisintegration.query.MantisQuery;
import java.awt.Image;
import java.beans.PropertyChangeListener;
import java.util.Collection;
import java.util.Collections;
import org.netbeans.modules.bugtracking.spi.RepositoryController;
import org.netbeans.modules.bugtracking.spi.RepositoryInfo;
import org.netbeans.modules.bugtracking.spi.RepositoryProvider;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;

public class MantisRepositoryProvider extends RepositoryProvider<MantisRepository,MantisQuery,MantisIssue> {

    @Override
    public RepositoryInfo getInfo(MantisRepository r) {
        return r.getInfo();
    }

    @Override
    public Image getIcon(MantisRepository r) {
        return r.getIcon();
    }

    @Override
    public MantisIssue[] getIssues(MantisRepository r, String... ids) {
        try {
            return r.getIssues(false, ids).toArray(new MantisIssue[0]);
        } catch (Exception ex) {
            NotifyDescriptor nd = new NotifyDescriptor.Exception(ex,
                    "Failed to get issues");
            DialogDisplayer.getDefault().notifyLater(nd);
            return new MantisIssue[0];
        }
    }

    @Override
    public void remove(MantisRepository r) {
        r.remove();
    }

    @Override
    public RepositoryController getController(MantisRepository r) {
        return r.getController();
    }

    @Override
    public MantisQuery createQuery(MantisRepository r) {
        return r.createQuery();
    }

    @Override
    public MantisIssue createIssue(MantisRepository r) {
        return r.createIssue();
    }

    @Override
    public Collection<MantisQuery> getQueries(MantisRepository r) {
        return r.getQueries();
    }

    @Override
    public Collection<MantisIssue> simpleSearch(MantisRepository r, String criteria) {
        try {
            return r.simpleSearch(criteria);
        } catch (Exception ex) {
            NotifyDescriptor nd = new NotifyDescriptor.Exception(ex,
                    "Failed to do simplesearch ");
            DialogDisplayer.getDefault().notifyLater(nd);
            return Collections.EMPTY_LIST;
        }
    }

    @Override
    public void removePropertyChangeListener(MantisRepository r, PropertyChangeListener pl) {
        r.removePropertyChangeListener(pl);
    }

    @Override
    public void addPropertyChangeListener(MantisRepository r, PropertyChangeListener pl) {
        r.addPropertyChangeListener(pl);
    }

}
