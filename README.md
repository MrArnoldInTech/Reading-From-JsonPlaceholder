# Reading-From-JsonPlaceholder

Requirements: Ideally you need to have Windows 10 or 11. You can also use MacOS.

IDE: Our environment where we will program is IntelliJ for Java, the community edition is okay
to use.

The goal of the application: to meet requirements that are set out by the client.

Create a connection to the website: https://jsonplaceholder.typicode.com.

Our client needs us to find the users and what their posts are.

In this application, we will be required to make a GET Request to the website. We want to read
the information that is on the page and to interpret it into our application.

![image](https://github.com/MrArnoldInTech/Reading-From-JsonPlaceholder/assets/72899208/4a93b36d-faa8-4279-98ab-8d03b1276089)

In this application, we want to call these two websites.
https://jsonplaceholder.typicode.com/posts
https://jsonplaceholder.typicode.com/users

![image](https://github.com/MrArnoldInTech/Reading-From-JsonPlaceholder/assets/72899208/a6c5cb90-6d39-4f0e-9163-8caa91c0a7d3)

First, this application will need to make sure that the jar file is loaded on the file structure
dependencies.

Go File, then press Project Structure

![image](https://github.com/MrArnoldInTech/Reading-From-JsonPlaceholder/assets/72899208/605199aa-e1ed-4d1e-a2c0-506385c02710)


Once Selected, make sure you are on the Modules tab that is seen on the left. In this
application, you will need to press + on the right then find where your JSON file is located and
add that to the program.

- Simply press apply and ok. Once added you will be able to work with JSON in our Java
application.

![image](https://github.com/MrArnoldInTech/Reading-From-JsonPlaceholder/assets/72899208/573bc2de-d862-406e-857d-b8174bb01743)

https://mvnrepository.com/artifact/org.json/json/20230227 - This is where the jar file was
originally from. This should already be attached to the project.

Perfect, once that is all sorted, please open the file main.java.

![image](https://github.com/MrArnoldInTech/Reading-From-JsonPlaceholder/assets/72899208/b25e8432-de1e-4118-a7e8-a4c1ce4d3b6e)

On your left, select main.java: This can be seen under .idea once you expand the folder down.
Once you have found the file we can now begin to run it.
Press the play button in the top right.

![image](https://github.com/MrArnoldInTech/Reading-From-JsonPlaceholder/assets/72899208/7bd44d4b-d97e-4472-b8e6-2758bcaa2520)

Once you have pressed play you are given two options. You can only type in users or posts.

![image](https://github.com/MrArnoldInTech/Reading-From-JsonPlaceholder/assets/72899208/6d734ba1-a2b0-4e4a-bba4-225a2734327a)

The example seen above shows what happens when the user inputs posts.
Once you have selected your option you can press the red square to close the program and
press the green play button to start again.

![image](https://github.com/MrArnoldInTech/Reading-From-JsonPlaceholder/assets/72899208/8aff63a3-89f0-4aea-8088-5b9a85d968a3)

The example seen above shows what happens when you write users in.
If you decide to not put the required input in, this will happen.

![image](https://github.com/MrArnoldInTech/Reading-From-JsonPlaceholder/assets/72899208/b2558f02-0557-4667-b4cc-14c99687aeb5)

This is the basics of what it will look like in running the application. The application merely
accepts two options only. You can only choose one or the other.

There are many ways this application could be approached, but for time and development I
went for the approach where you enter what you need and if you want to search again you just
merely run the program again.

Note: when running the application it might say select JDK.

I used this one:

![image](https://github.com/MrArnoldInTech/Reading-From-JsonPlaceholder/assets/72899208/d2cd7788-79be-4c35-84bc-a3e0e23dcbf9)

However, you can use the latest one, I believe I tested it and it worked okay on the latest
module version as well.














