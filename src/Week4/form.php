<!DOCTYPE html>
<html>
    <head>
        <title>Form</title>
    </head>
    <body>
        <form method="POST">
            <label>Your Name</label>
            <input id="id" name="name" type="text"/>
            <input id="btn" type="submit" value="Submit"/><br/>
        </form>
        <p id="display"><?php
                if ($_POST["name"]) {
                    echo $_POST["name"];
                }
            ?></p>
    </body> 
</html>