package no.hib.dpf.editor.commands;

import org.eclipse.gef.commands.Command;

public final class EmptyExecutableCommand extends Command {
	/**
	 * The singleton instance
	 */
	public static final EmptyExecutableCommand INSTANCE = new EmptyExecutableCommand();

	private EmptyExecutableCommand() {
	}

	/**
	 * @return <code>false</code>
	 */
	@Override
	public boolean canExecute() {
		return true;
	}

	/**
	 * @return <code>false</code>
	 */
	@Override
	public boolean canUndo() {
		return true;
	}
}
