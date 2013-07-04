 
package de.gammas.e4.multithreading.handlers;

import javax.inject.Named;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.services.IServiceConstants;

import Jobs.MyJob;
import de.gammas.e4.multithreading.parts.SamplePart;

public class RefreshCommand {
	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_PART) MPart mpart, final UISynchronize uiSynchronize) {
		final SamplePart samplePart = (SamplePart) mpart.getObject();
		
		
		MyJob job = new MyJob("MyJob", samplePart, uiSynchronize);
		
		job.schedule();
		
		
	}
		
}