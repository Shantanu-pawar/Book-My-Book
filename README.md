# Book-My-Book


* Book my book is a system that holds the information of how many books issued by students in collage library.
* Maintain track record of which author written how many books **with book names** and we have categories of all authors
  `ex : HISTORY, FICTION, ACTIONS, COMICS etc.` so that students can easily shortlist accordingly.
* Its a backend code written using Spring-Boot
* It consists of Different Layers like Controller, Service, Repository , DTO(Data Transfer Object)
* These layers in the project increases its code maintanablity, understadability and readablity

___
# Functionality

## I. For Authors
 Authors can :-
- Register himself/herself in the system.
- Add a book.
- Add new Genre type.


## II. For User(student):
  Students can :-
- Student can add himself on portal as new student 
- Issue the book
- students have their specific departments so we can find student's department from their ID.


# Different Models / Entities / (Table in MySQL) In the Project
- Author Entity
- Student Entity
- LibraryCard Entity
- Book Entity
- Transaction Entity


# Teck-Stack Used :
- Spring-Boot
- MySQL
- Java
- Hibernate
- JPA

# Schema Design

<img src="https://github.com/Shantanu-pawar/Book-My-Book/assets/87530022/3de6a49a-ce8e-45f0-9eb8-abb991bd1a22" 
  alt="image" width="800">
<br>

# Author API's

- `Add Author`
<img src="https://github.com/Shantanu-pawar/Book-My-Book/assets/87530022/d53aa6e3-34d7-48b0-be8f-cb6ca990630f"
  alt="image" width="500"> <br>



# Book API's

- `Add book` <br>
  ![image](https://github.com/Shantanu-pawar/Book-My-Book/assets/87530022/aaa29b01-8af2-4233-8aa2-d7240580d806)
  ![image](https://github.com/Shantanu-pawar/Book-My-Book/assets/87530022/b633a4e3-d5d3-4573-bee4-f73a5b4a1fc0)

- `get books by it's Genre` <br>
![image](https://github.com/Shantanu-pawar/Book-My-Book/assets/87530022/7d194b31-134f-495f-8790-417d623672e4)


# Card API's 

- `Add card `  <br>
![image](https://github.com/Shantanu-pawar/Book-My-Book/assets/87530022/a65338be-70f9-4cff-a307-a49765672c0b)
<br>
![image](https://github.com/Shantanu-pawar/Book-My-Book/assets/87530022/056d7dfb-46cd-4417-93c4-ba59729e37d3)


