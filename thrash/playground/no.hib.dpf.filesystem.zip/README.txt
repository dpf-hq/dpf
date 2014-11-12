This work is based on the EFS introduction article by Alex Blewitt.
The article can be found here: http://www.eclipsezone.com/articles/efs/

The project contains a virtual file system based on Eclipse File System for mounting zip files
directly in a Eclipse project. The work was only a way for me (Anders) to get to know the Eclipse eco-system
in the beginning of my thesis. The file system was meant as introductory work on a custom file format for
the Eclipse project, and is not used within the DPF Workbench.

Even though an eventual DPF file format use another approach, this project can at least show how the EFS works.

It is not by any means complete. As far as I remember, it works by linking a file in the .project description 
file. It is then mounted in the workspace. Recursive deletion is not implemented due to some synchronization
issues when accessing an internal collection.

The project has _not_ been tested after it was refactored out of no.hib.dpf.api (which no longer exists).

