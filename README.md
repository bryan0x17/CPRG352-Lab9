# CPRG352 Lab 9
*Bryan Meyer*

This lab builds on the functionality introduced into the Notes Keeper app from previous lab. In this lab, the goal is to add reset password functionality to the app using an email service. I have decided to use Gmail for this, since it's easy and free. The app will process a user's request to reset their password and send them an email with a link containing a unique random UUID. If the user follows the link, they'll be prompted to enter their email again, along with a new password. The app will check that the email and UUID match what's stored in the database, and if so, will update the password and nullify the UUID.

**Note**: I realize that I commited my email and password in the web.xml file. These credentials are no longer valid and pose no security threat to me. Please replace these values with your own email username and password when running the app.

## How to run

The app was made in Netbeans 12 using Tomcat 8 and MariaDB. To run it as is, you will need to open the project in Netbeans and run the notesdb.sql file in the database package inside your MariaDB client to create the database. You should then be able to run the project from your Netbeans. Remember to change the username and password in the web.xml file to your Gmail username and password, and to allow less secure apps on your Google account.