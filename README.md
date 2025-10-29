1. Project Title
	A simple quizz aplication. Project is created using Spring Boot and Thymeleaf based on the MVC architecture.

2. Description
	This application allows users to take multiple-choice quizzes, see their results, and retake quizzes. 
	Quizzes are loaded from a JSON file.

3. Features / Requirements Implemented
	- Display 15 multiple-choice questions one at a time
	- when starting the app it starts with the first question
	- All questions are with multiple choices(from A to D)
	- There are navigation buttons Next/Previous to shuffle through the questions
	- There is a submit button on the end of the quiz
	- On the results page is displayed how many answers are correct and the total number of questions
	- On the results page all wrong questions are displayed with the respective correct answers.

4. Technologies Used
	- Java 21
	- Spring Boot
	- Thymeleaf
	- Maven
	- Bootstrap / CSS for styling (optional)
	- Lombok

5. Setup / Installation / Run

	1. Download the file app-0.0.1-SNAPSHOT.jar from: 
		https://github.com/OrlinGit/quizapp/releases/tag/v1.0.0

	2. Open a Terminal or Command Prompt in the folder where the .jar file is saved, or navigate there

	3. Run the .jar file with the following command: java -jar app-0.0.1-SNAPSHOT.jar 

	4. Spring Boot will start the program. 

	5. After Spring Boot has started, open you browser and to go to:
  		 http://localhost:8080/home (make sure that the port is not used by another application)

	6. Enjoy


6. Usage
	- Select a quiz from the home page
	- Answer questions using radio buttons
	- Click Submit to see results
	- Retake quiz by clicking the "Retake Quiz" button

8. Notes
	- No database or authentication implemented
	- All data is loaded from JSON
	- Jason file is AI generated
	- css file is AI generated
