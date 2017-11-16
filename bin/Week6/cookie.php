<!DOCTYPE html>
<?php
$cookie_name_user = "user";
if (!isset($_COOKIE[$cookie_name_user])) {
    $cookie_name_user = "user";
    $cookie_value_user = "JohnDoe";
    setcookie($cookie_name_user, $cookie_value_user, 
            time()+86400, "/", "");
}
$cookie_name_password = "password";
if (!isset($_COOKIE[$cookie_name_password])) {
    $cookie_name_password = "password";
    $cookie_value_password = "secret";
    setcookie($cookie_name_password, $cookie_value_password, 
            0, "/", "");
}
?>
<html>
    <head>
        <title>Cookie</title>
    </head>
    <body>
        <?php
        if (!isset($_COOKIE[$cookie_name_user])) {
            echo "<p>Cookie named '" . $cookie_name_user . "' does not exist with the current HTTP request!</p>";
        } else {
            echo "<p>Cookie '" . $cookie_name_user . "' is set with value " . $_COOKIE[$cookie_name_user] . "</p>";
        }
        if (!isset($_COOKIE[$cookie_name_password])) {
            echo "<p>Cookie named '" . $cookie_name_password . "' does not exist with the current HTTP request!</p>";
        } else {
            echo "<p>Cookie '" . $cookie_name_password . "' is set with value " . $_COOKIE[$cookie_name_password] . "</p>";
        }
        ?>
    </body>
</html>