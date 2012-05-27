package no.hib.dpf.editor.wizards;
/*******************************************************************************
 * Copyright (c) 2000, 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM Corporation - initial API and implementation 
 *   Sebastian Davids <sdavids@gmx.de> - Fix for bug 19346 - Dialog
 * 	 	font should be activated and used by other components.
 *******************************************************************************/

//import org.eclipse.core.filesystem.IFileStore;
import java.net.URI;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.WizardNewLinkPage;

/**
 * This class is copypasta from {@link WizardNewLinkPage} which can't be subclassed.
 * Internal classes has been replaced with Eclipse API classes. 
 * The Variable button has been removed, as well as validation for folders.
 */
public class DPFWizardPage extends WizardPage {
    private String initialLinkTarget;

    private boolean createLink = false;

    // widgets
    private Text targetField;

    private Button browseButton;

    private final String linkName;

	private String[] filterExtensions = null;

	private String[] filterNames = null;

    public DPFWizardPage(String pageName, String name) {
        super(pageName);
        this.linkName = name;
        setPageComplete(true);
    }

    /* (non-Javadoc)
     * Method declared on IDialogPage.
     */
    public void createControl(Composite parent) {
        Font font = parent.getFont();
        initializeDialogUnits(parent);
        // top level group
        Composite topLevel = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        layout.numColumns = 3;
        topLevel.setLayout(layout);
        topLevel.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_FILL
                | GridData.HORIZONTAL_ALIGN_FILL));
        topLevel.setFont(font);
//        PlatformUI.getWorkbench().getHelpSystem().setHelp(topLevel,
//				IIDEHelpContextIds.NEW_LINK_WIZARD_PAGE);

        final Button createLinkButton = new Button(topLevel, SWT.CHECK);
		
        createLinkButton.setText("&Load file:");
        
		createLinkButton.setSelection(createLink);
        GridData data = new GridData();
        data.horizontalSpan = 3;
        createLinkButton.setLayoutData(data);
        createLinkButton.setFont(font);
        SelectionListener listener = new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                createLink = createLinkButton.getSelection();
                browseButton.setEnabled(createLink);
                targetField.setEnabled(createLink);
                setPageComplete(validatePage());
            }
        };
        createLinkButton.addSelectionListener(listener);

        createLinkLocationGroup(topLevel, createLink);
        validatePage();

        setErrorMessage(null);
        setMessage(null);
        setControl(topLevel);
    }

    /**
     * Creates the link target location widgets.
     *
     * @param locationGroup the parent composite
     * @param enabled sets the initial enabled state of the widgets
     */
    private void createLinkLocationGroup(Composite locationGroup,
            boolean enabled) {
        Font font = locationGroup.getFont();
        Label fill = new Label(locationGroup, SWT.NONE);
        GridData data = new GridData();
        Button button = new Button(locationGroup, SWT.CHECK);
        data.widthHint = button.computeSize(SWT.DEFAULT, SWT.DEFAULT).x;
        button.dispose();
        fill.setLayoutData(data);

        // link target location entry field
        targetField = new Text(locationGroup, SWT.BORDER);
        data = new GridData(GridData.FILL_HORIZONTAL);
        targetField.setLayoutData(data);
        targetField.setFont(font);
        targetField.setEnabled(enabled);
        targetField.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent e) {
                setPageComplete(validatePage());
            }
        });
        if (initialLinkTarget != null) {
            targetField.setText(initialLinkTarget);
        }

        // browse button
        browseButton = new Button(locationGroup, SWT.PUSH);
        setButtonLayoutData(browseButton);
        browseButton.setFont(font);
        browseButton.setText("&Browse...");
        browseButton.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent event) {
                handleLinkTargetBrowseButtonPressed();
            }
        });
        browseButton.setEnabled(enabled);
        
        fill = new Label(locationGroup, SWT.NONE);
        data = new GridData();
        data.horizontalSpan = 2;
        fill.setLayoutData(data);
    }

    /**
     * Returns the link target location entered by the user. 
     *
     * @return the link target location entered by the user. null if the user
     * 	choose not to create a link.
     */
    public String getLinkTarget() {
        if (createLink && targetField != null
                && targetField.isDisposed() == false) {
            return targetField.getText();
        }
        return null;
    }

    /**
     * Opens a file or directory browser depending on the link type.
     */
    private void handleLinkTargetBrowseButtonPressed() {
        String linkTargetName = targetField.getText();
        String selection = null;
        IFileStore store = null;
        if (linkTargetName.length() > 0) {
            store = getFileStore(linkTargetName);
            if (store == null || !store.fetchInfo().exists()) {
            	store = null;
            }
        }
        
        FileDialog fileDialog = new FileDialog(getShell(), SWT.SHEET);
        fileDialog.setFilterExtensions(filterExtensions);
        fileDialog.setFilterNames(filterNames);
        
        if (store != null) {
        	if (store.fetchInfo().isDirectory()) {
        		fileDialog.setFilterPath(linkTargetName);
        	} else {
        		fileDialog.setFileName(linkTargetName);
        	}
        }
        selection = fileDialog.open();
        
        if (selection != null) {
            targetField.setText(selection);
            System.out.println(selection);
        }
    }

    /**
     * Sets the value of the link target field
     * 
     * @param target the value of the link target field
     */
    public void setLinkTarget(String target) {
        initialLinkTarget = target;
        if (targetField != null && targetField.isDisposed() == false) {
            targetField.setText(target);
        }
    }

    private boolean validateFileType(IFileStore linkTargetStore) {
        boolean valid = true;

        if (linkTargetStore.fetchInfo().isDirectory()) {
            setErrorMessage(linkName + " must be a file");
            valid = false;
        }
        return valid;
    }

    /**
     * Validates the name of the link target
     *
     * @param linkTargetName link target name to validate
     * @return boolean <code>true</code> if the link target name is valid
     * 	and <code>false</code> otherwise.
     */
    private boolean validateLinkTargetName(String linkTargetName) {
        boolean valid = true;

        if ("".equals(linkTargetName)) {//$NON-NLS-1$
            setErrorMessage(linkName + " must be specified");
            valid = false;
        } else {
            IPath path = new Path("");//$NON-NLS-1$
            if (path.isValidPath(linkTargetName) == false) {
                setErrorMessage(linkName + " name invalid");
                valid = false;
            }
        }
        return valid;
    }

    /**
     * Returns whether this page's controls currently all contain valid 
     * values.
     *
     * @return <code>true</code> if all controls are valid, and
     *   <code>false</code> if at least one is invalid
     */
    private boolean validatePage() {
        boolean valid = true;
//        IWorkspace workspace = ResourcesPlugin.getWorkspace();

        if (createLink) {
            String targetName = targetField.getText();

            valid = validateLinkTargetName(targetName);
            if (valid) {
                IFileStore targetFile = getFileStore(targetName);
                if (targetFile == null || !targetFile.fetchInfo().exists()) {
                    setErrorMessage(linkName + " target does not exist");
                    valid = false;
                } else {
                	//validatePath does not work for windows version. And i think it is not necessary to validate Path, The use choose the file. So the path should be valid by default.
//                	IStatus locationStatus = workspace.validatePath(targetName, IResource.FILE);
//
//                    if (locationStatus.isOK() == false) {
//                        setErrorMessage(linkName + " location is invalid");
//                        valid = false;
//                    } else {
                        valid = validateFileType(targetFile);
//                    }
                }
            }
        }
        // Avoid draw flicker by clearing error message
        // if all is valid.
        if (valid) {
            setMessage(null);
            setErrorMessage(null);
        }
        return valid;
    }
    
    public void setFileDialogFilters(String[] filterExtensions, String[] filterNames) {
    	this.filterExtensions = filterExtensions;
    	this.filterNames = filterNames;
    }
    
    /**
	 * Get the file store for the string.
	 * 
	 * @param string
	 * @return IFileStore or <code>null</code> if there is a
	 *         {@link CoreException}.
	 */
	public static IFileStore getFileStore(String string) {
		return getFileStore(new Path(string).toFile().toURI());
	}

	/**
	 * Get the file store for the URI.
	 * 
	 * @param uri
	 * @return IFileStore or <code>null</code> if there is a
	 *         {@link CoreException}.
	 */
	public static IFileStore getFileStore(URI uri) {
		try {
			return EFS.getStore(uri);
		} catch (CoreException e) {
			e.printStackTrace();
			return null;
		}
	}
}
