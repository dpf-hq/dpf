package no.hib.dpf.editor.utilities;
 
import no.hib.dpf.core.Arrow;
import no.hib.dpf.core.ArrowAttribute;
import no.hib.dpf.core.DataNode;
import no.hib.dpf.core.Node;
import no.hib.dpf.core.NodeAttribute; 
import no.hib.dpf.diagram.DArrow;
import no.hib.dpf.diagram.DNode;  
import no.hib.dpf.utils.DPFCoreConstants;

import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem; 
import org.eclipse.swt.SWT; 
import org.eclipse.swt.widgets.Text; 
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button; 
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.custom.ScrolledComposite; 

public class DynamicArrowAttributeDialog extends Dialog {

	protected Shell shell;
	private DArrow darrow;
	Table table;
	TableEditor editor;
	
	private final int TABLE_COLUMN_NAME_INDEX = 0;
	private final int TABLE_COLUMN_VALUE_INDEX = 1;
	private final int TABLE_COLUMN_MUTABILITY_INDEX = 2;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public DynamicArrowAttributeDialog(Shell parent, DArrow darrow) {
		super(parent, SWT.ON_TOP);
		this.darrow = darrow;
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public DArrow open() {
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		getParent().setEnabled(false);
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		getParent().setEnabled(true);
		return darrow;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), SWT.DIALOG_TRIM);
		shell.setSize(397, 222);
		shell.setText("Set ArrowAttribute-Values for: " + darrow.getName());
		Monitor primary = shell.getMonitor();
	    Rectangle bounds = primary.getBounds();
	    Rectangle rect = shell.getBounds();
	    
	    int x = bounds.x + (bounds.width - rect.width) / 2;
	    int y = bounds.y + (bounds.height - rect.height) / 2;
	    
	    shell.setLocation(x, y);
		shell.setLayout(null);
		
		
		
		Button btnOk = new Button(shell, SWT.NONE);
		btnOk.setBounds(224, 162, 95, 25);
		btnOk.setText("Ok");
		btnOk.addListener(SWT.Selection, new NodeAttributeActionListener());
		
		Button btnCancel = new Button(shell, SWT.NONE);
		btnCancel.setText("Cancel");
		btnCancel.setBounds(325, 162, 56, 25);
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setBounds(10, 12, 371, 144);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		
		table = new Table(scrolledComposite, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
	    TableColumn attributeName = new TableColumn(table, SWT.NONE);
	    attributeName.setWidth(137);
	    attributeName.setText("Name");
	
	    TableColumn value = new TableColumn(table, SWT.NONE);
	    value.setWidth(50);
	    value.setText("Value");
	    
	    TableColumn mutability = new TableColumn(table, SWT.NONE);
		mutability.setWidth(50);
		mutability.setText("Mutability");
	    
	    
	    fillTable(table);
	    attributeName.pack();
	    value.pack();
	    mutability.pack();
		btnCancel.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				shell.dispose();
			}
		});

		addTableEditor(table);
	}
	
	private void fillTable(Table table) {
		Arrow arrow = darrow.getArrow();
		for (ArrowAttribute outgoingAttr : arrow.getOutgoingAttributes()) {
			DataNode datanode = outgoingAttr.getTarget();
			if(datanode != null){
				TableItem item = new TableItem(table, SWT.NONE);
				
				NodeAttribute metaLangAttr = (NodeAttribute) outgoingAttr.getElement(-2); 
				if(metaLangAttr != null && metaLangAttr.getName().equals(DPFMetaLanguageUtils.NODE_VALUE)){
					CCombo datatypeCombo = new CCombo(table, SWT.NONE);
					
					for (String datatype : DPFCoreConstants.getEDataTypesMap().keySet()) {
						datatypeCombo.add(datatype);
					}
					datatypeCombo.pack();
				    TableEditor editor = new TableEditor(table);
				    editor.grabHorizontal = true;
				    editor.setEditor(datatypeCombo, item, TABLE_COLUMN_VALUE_INDEX);
					item.setText(TABLE_COLUMN_NAME_INDEX, outgoingAttr.getName());
					item.setText(TABLE_COLUMN_MUTABILITY_INDEX, "" + datanode.getMutability());
				}else{
					item.setText(new String[] {outgoingAttr.getName(), datanode.getValue(), "" + datanode.getMutability()});
				}
				
				item.setData(datanode);
			}
		}	
	}
	
	private void addTableEditor(final Table table) {
		final TableEditor editor = new TableEditor(table);
        editor.horizontalAlignment = SWT.LEFT;
        editor.grabHorizontal = true;
        table.addListener(SWT.MouseDown, new Listener() {
			public void handleEvent(Event event) {
			      Rectangle clientArea = table.getClientArea();
			      Point pt = new Point(event.x, event.y);
			      int index = table.getTopIndex();
			      while (index < table.getItemCount()) {
			        boolean visible = false;
			        final TableItem item = table.getItem(index);
			        for (int i = 0; i < table.getColumnCount(); i++) {
			        	// Clean up any previous editor control
		    			Control oldEditor = editor.getEditor();
		    			if (oldEditor != null) oldEditor.dispose();
			        	
				          Rectangle rect = item.getBounds(i);
				          if (rect.contains(pt)) {
				            final int column = i;
				            
				            if(column == TABLE_COLUMN_VALUE_INDEX){
					            	final CCombo combo = new CCombo(table, SWT.NONE);
									for (String datatype : DPFCoreConstants.getEDataTypesMap().keySet()) {
										combo.add(datatype);
									}
	
						            // Select the previously selected item from the cell
						            combo.select(combo.indexOf(item.getText(column)));
	
						            // Compute the width for the editor
						            // Also, compute the column width, so that the dropdown fits
						            editor.minimumWidth = combo.computeSize(SWT.DEFAULT, SWT.DEFAULT).x;
						            table.getColumn(column).setWidth(editor.minimumWidth);
	
						            // Set the focus on the dropdown and set into the editor
						            combo.setFocus();
						            editor.setEditor(combo, item, column);
	
						            // Add a listener to set the selected item back into the cell
						            combo.addSelectionListener(new SelectionAdapter() {
						              public void widgetSelected(SelectionEvent event) {
						                item.setText(column, combo.getText());
	
						                // They selected an item; end the editing session
						                combo.dispose();
						              }
						            });  
						            
						            Listener textListener = new Listener() {
						            	public void handleEvent(final Event e) {
						                switch (e.type) {
						                case SWT.FocusOut:
						                  item.setText(column, combo.getText());
						                  combo.dispose();
						                  break;
						                case SWT.Traverse:
						                  switch (e.detail) {
						                  case SWT.TRAVERSE_RETURN:
						                    item.setText(column, combo.getText());
						                  // FALL THROUGH
						                  case SWT.TRAVERSE_ESCAPE:
						                	  combo.dispose();
						                    e.doit = false;
						                  }
						                  break;
						                }
						              }
						            };
						            combo.addListener(SWT.FocusOut, textListener);
						            combo.addListener(SWT.Traverse, textListener);
				            }else if(column > TABLE_COLUMN_VALUE_INDEX){
				            	
					            final Text text = new Text(table, SWT.NONE);
					            Listener textListener = new Listener() {
					            	public void handleEvent(final Event e) {
					                switch (e.type) {
					                case SWT.FocusOut:
					                  item.setText(column, text.getText());
					                  text.dispose();
					                  break;
					                case SWT.Traverse:
					                  switch (e.detail) {
					                  case SWT.TRAVERSE_RETURN:
					                    item.setText(column, text.getText());
					                  // FALL THROUGH
					                  case SWT.TRAVERSE_ESCAPE:
					                    text.dispose();
					                    e.doit = false;
					                  }
					                  break;
					                }
					              }
					            };
					            text.addListener(SWT.FocusOut, textListener);
					            text.addListener(SWT.Traverse, textListener);
					            editor.setEditor(text, item, i);
					            text.setText(item.getText(i));
					            text.selectAll();
					            text.setFocus();
				            }
				            
				            return;
				          }
				          if (!visible && rect.intersects(clientArea)) {
				            visible = true;
				          }
			        }
			        
			        if (!visible){
			          return;
			        }
			        index++;
			      }
			}
          });
	}

	

	/**
	 * 
	 * @author Ole Klokkhammer
	 */
	class NodeAttributeActionListener implements Listener {

		@Override
		public void handleEvent(Event e) {
			if (e.type == SWT.Selection) {
				Arrow arrow = darrow.getArrow();
				
				for (ArrowAttribute outgoingAttr : arrow.getOutgoingAttributes()) {
					for (TableItem tableItem : table.getItems()) {
						if(tableItem.getText(TABLE_COLUMN_NAME_INDEX).trim().equals(outgoingAttr.getName())){
							DataNode targetDatanode = outgoingAttr.getTarget();
							if(targetDatanode != null){
								if(tableItem.getText(TABLE_COLUMN_VALUE_INDEX).length() > 0){
									targetDatanode.setValue(tableItem.getText(TABLE_COLUMN_VALUE_INDEX));
								}
								//targetDatanode.setMutability(tableItem.getText(TABLE_COLUMN_MUTABILITY_INDEX));
							}
						}
					}
				}
				
				
				// close the dialog
				shell.dispose();
			}
		}
	}
}
