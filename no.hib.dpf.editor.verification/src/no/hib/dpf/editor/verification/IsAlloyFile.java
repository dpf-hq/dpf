package no.hib.dpf.editor.verification;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IFile;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;

public class IsAlloyFile extends PropertyTester {

	public IsAlloyFile() {
	}

	@Override
	public boolean test(Object receiver, String property, Object[] args,
			Object expectedValue) {
		if (args.length == 0 && receiver instanceof IEditorPart) {
			IEditorPart editor = (IEditorPart) receiver;
			if(!(editor.getEditorInput() instanceof IFileEditorInput)) return false;
			IFile dpfFile = ((IFileEditorInput)editor.getEditorInput()).getFile();
				if(dpfFile != null)
						if(!dpfFile.getName().endsWith(".dpf")) return false;
		}
		return true;
	}

}
