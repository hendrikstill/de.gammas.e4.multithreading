package Jobs;

import javax.swing.text.StyleContext.SmallAttributeSet;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.e4.ui.di.UISynchronize;

import de.gammas.e4.multithreading.parts.SamplePart;

public class MyJob extends Job {

	private SamplePart samplePart;
	private UISynchronize uiSynchronize;

	public MyJob(String name, SamplePart samplePart, UISynchronize uiSynchronize) {
		super(name);
		this.samplePart = samplePart;
		this.uiSynchronize = uiSynchronize;
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {

		try {
			Thread.sleep(1000);
			uiSynchronize.asyncExec(new Runnable() {
				public void run() {
					samplePart.addStringToList("Blub");
				}
			});
			this.schedule();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Status.OK_STATUS;
	}

}
