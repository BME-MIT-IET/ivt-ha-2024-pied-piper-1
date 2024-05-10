
## Static Analysis Tool Summary

For the static analysis we used Lint which is an android studio tool that helps detect potential issues, bugs and coding style violations in the source code without executing it. We added Lint to our project to make our code better and find mistakes easily.

The Lint report contained various kinds of warnings and problems and the team focused on issues in different categories such as peformance, internationalization and correctness. Two correctness, three performance and one internationalization issue were reviewed by the team. 

While some of the issues were causing bugs in the program, some of them caused performance issues. The correctness issues were both caused by participating in practices that are obsolete, and showed us that projects need to be continuously updated. The internationalization issue was one that had +55 occurrences where the text was hardcoded: it showed us how mistakes can be repeated many times without being noticed. The performance problems were caused not only by redoing the same action several times but also by obsolete practices and long vector paths. After this part of the assignment it became obvious that a seemingly working program is not necessarily an efficient one.
