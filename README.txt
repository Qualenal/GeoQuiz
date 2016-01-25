Assignment 1: GeoQuiz with multiple question types, and score tracking

1. I converted the original Question class into an abstract class, with a field to store the Question
text, and an abstract function that checked whether the user answered correctly. This Question class
had descendants for each type of object, so the Question array could hold all the different types.

2. Yes, the choice in storing the models was very important in how the controller was set up. I was
able to use the Java keyword instanceof to check the class of the Question objects, and properly update
the display. I believe this is the most OO approach to the problem.

3. I had a lot of trouble finding when I was allowed to find the various buttons in the layout. and
update their text. I tried to declare them as class variables in the QuizActivity class, but that
resulted in NullPointerExceptions at runtime. I am also confused at exactly how the QuizActivity is
running its functions, which appear to run even if not explictly called.