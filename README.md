Before writing code, think of the algorithm, make a tentative design.

Write failing tests for this algorithm.

Make the tests pass, starting with a very basic design for the code (maybe just a single class).

Start by making simple tests pass, then move on to complex tests.

Always start with failing tests, else your test may actually test nothing.

Refactor code continuously to make it readable. Write simple methods, compose complex methods from these.

Keep the tests passing during all refactorings.

Once all your tests are passing, any code that does not result in a test failure can (and should) be
thrown out. 

KISS.

If necessary, once you have better insight into the algorithm, throw out code and start again with a cleaner
design. Do this with Katas!

Do code reviews - you are probably not the best judge as to whether your own code is readable.

The design can be driven by the cycles of testing and refactoring, for example:
private methods indicate that your class should be split, creating a new class for those methods. Especially if the private methods get to be complex enough that you want to test them directly.

Comments should only exist if they tell you something which the code cannot. Otherwise comments are a code smell - they indicate that complex methods have not been broken down into simple methods and methods have been given ambiguous names.

A good comment and method: 
//Ops told us there are never more than 200 users so efficiency of sorting algorithm is not paramount
User [] sortBySurnameThenAgeDescending(Set<User>users);

A bad comment and method : 
//sorts the users by surname then by age into an array using bubblesort and returns the sorted array
User [] getUsers(Set<User>users);
