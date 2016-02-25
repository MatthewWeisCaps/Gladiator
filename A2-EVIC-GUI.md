# Assignment 2: EVIC Graphical User Interface (GUI) App

**Deadline: February 28, 2016, 11:59pm, US Central**

## Tasks

In this second assignment, you are to develop an EVIC GUI app that has the
same functionality to the first assignment's EVIC console app.

You are given the freedom to design and develop the EVIC app UI visual elements
and cues; there is no standardized form for the UI for this assignment.

As a reference, however, the model solution visual elements look as follows 
(annotated with the name of Windows Form controls):


It makes use of:

* [`TextBox`](http://www.dotnetperls.com/textbox), to enter a todo entry.
  A solution uses the 
  [`KeyDown`](http://msdn.microsoft.com/en-us/library/system.windows.forms.control.keydown(v=vs.110).aspx)
  event to detect when an enter key is pressed (see 
  http://stackoverflow.com/questions/12318164/enter-key-press-in-c-sharp);
  if so, it is considered as entering a new entry (if the text in the `TextBox` 
  is non-empty).

* [`ListView`](http://www.dotnetperls.com/listview), to display the entries.
  Note that `ListView` allows a checkbox to be associated with each item that
  can be used to display/change an entry status (see
  [`ItemChecked`](http://msdn.microsoft.com/en-us/library/system.windows.forms.listview.itemchecked(v=vs.110).aspx).
  In addition, it supports inline editing of item text that can be used to edit
  an entry description (see
  [`AfterLabelEdit`](http://msdn.microsoft.com/en-us/library/system.windows.forms.listview.afterlabeledit(v=vs.110).aspx)).
  Moreover, it supports dragging items (see
  [`ItemDrag`](http://msdn.microsoft.com/en-us/library/system.windows.forms.listview.itemdrag(v=vs.110).aspx))
  that is as a gesture to delete an entry.
   
* [`ComboBox`](http://www.dotnetperls.com/combobox)
(see [`SelectedIndexChanged`](http://msdn.microsoft.com/en-us/library/system.windows.forms.combobox.selectedindexchanged(v=vs.110).aspx)).

* [`Button`](http://www.dotnetperls.com/button).
  
* [`Label`](http://www.dotnetperls.com/label). 
  
You can choose to use the above Windows Form controls or to use different ones
from the standard Windows Form toolbox.

Your specific task for this assignment is to *refactor* your A1 solution to
implement a EVIC GUI app as described above.
Essentially, you now need to separate the code that implements the EVIC 
functionality with its Console and GUI "presentations".

In A1, you have one Console App project and a test project.
The solution for A2 requires 4 projects:
   
1. A "Class Library" project that holds the implementation of the EVIC
   functionality that should be **shared** between the EVIC Console and the EVIC GUI 
   apps. 
      
2. The A1 "Console App" project. The code has to be modified to use the shared
   code in the "Class Library" project"; that is, this project depends on the 
   "Class Library" project.
        
3. A "GUI App" project that holds the implementation of the EVIC GUI.
   This project depends on the "Class Library" project.
   
4. The A1 test project that holds the console app test from A1.
   This project depends on the "Class Library" and the "Console App" project.
   
When working on your solution, share as much as code between the Console
and the GUI apps and put them in the "Class Library" project.

First, create the "Class Library" and the "GUI App" projects:

1. Open your A1 Visual Studio Solution

2. Create the "Class Library" project.
   In Solution Explorer, right-click on "Solution 'A1-EVIC'" and select 
   "Add"->"New Project...". Select "Visual C#"->"Windows Desktop" and then 
   select "Class Library"; name the project "EVIC" and click "OK".

3. Create the "GUI App" project.
   In Solution Explorer, right-click on "Solution 'A1-EVIC'" and select 
   "Add"->"New Project...". Select "Visual C#"->"Windows Desktop" and then 
   select "Windows Forms Application"; name the project "EVIC-GUI" and click 
   "OK".
   
4. Add reference from the "EVIC-Console", "EVIC-GUI", and the test project 
   "EVIC-Console-Test" to the "Class Library" project. 
   For each project:
   
   A. open the project tree to show its "References"
   
   B. right-click on the project "References" and then select 
      "Add Reference...". In the dialog window under "Solution"->"Projects",
      check the "EVIC" project.
       
   This allows classes defined in the "EVIC" class library project to be used by
   the other projects (do not forget to import the "EVIC" class library 
   namespace, e.g., `using EVIC;` for each cs file using the "EVIC" classes). 
   
5. Move EVIC-list functionality code from the "EVIC-Console" project to the
   "EVIC" project; this requires modification to the console app (e.g., adding
   `using EVIC;`, etc.).
   You can test your modified "EVIC-Console" using the tests that you developed
   for A1 to make sure that the app does not *regress* (i.e., it maintains the
   same functionality). 

6. Implement the GUI app (by using the code in the "EVIC" class library project).


## Submission

To submit, make modifications your A1 solution as described above, and then 
commit and push your solution to GitHub by the deadline

**No email submission will be accepted starting with this assignment.**

