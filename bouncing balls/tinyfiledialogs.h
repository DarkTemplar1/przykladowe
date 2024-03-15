#ifndef TINYFILEDIALOGS_H
#define TINYFILEDIALOGS_H
#ifdef	__cplusplus
#endif

extern int tinyfd_forceConsole ;
char const * tinyfd_saveFileDialog (
    char const * const aTitle ,
    char const * const aDefaultPathAndFile ,
    int const aNumOfFileFilters ,
    char const * const * const aFileFilters ) ;

char const * tinyfd_openFileDialog (
    char const * const aTitle ,
    char const * const aDefaultPathAndFile ,
    int const aNumOfFileFilters ,
    char const * const * const aFileFilters ,
    int aAllowMultipleSelects ) ;

char const * tinyfd_selectFolderDialog (
	char const * const aTitle ,
    char const * const aDefaultPath ) ;

int tinyfd_messageDialog (
    char const * const aTitle ,
    char const * const aMessage ,
    char const * const aDialogType ,
    char const * const aIconType ,
    int const aDefaultButton ) ;
char const * tinyfd_colorChooser(
	char const * const aTitle ,
	char const * const aDefaultHexRGB ,
	unsigned char aDefaultRGB[3] ,
	unsigned char aoResultRGB[3] ) ;
#ifdef	__cplusplus
#endif /* __cplusplus */

#endif /* TINYFILEDIALOGS_H */


/*
- On windows: link against Comdlg32.lib User32.lib and Shell32.lib
- On unix: it tries command line calls, so no such need.
- Use windows separator on windows and unix separator on unix.
- char const * fileFilters[3] = { "*.obj" , "*.stl" , "*.dxf" } ;
- String memory is preallocated statically for all the returned values.
- On unix you need zenity or kdialog or python2/tkinter or dialog installed.
  Don't worry, it's already included on most (if not all) desktops.
- If you pass only a path instead of path + filename,
  make sure it ends with a separator.
- tinyfd_forceConsole=1; forces all dialogs into console mode.
*/
