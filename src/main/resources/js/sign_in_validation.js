function checkForm(el) {
    var name = el.name.value;
    var password = el.password.value;
    var email = el.email.value;
    let name_fail = "";
    let email_fail = "";
    let password_fail = "";
    console.log(name+" "+ password+" "+ email);
    if (name === "") {
        name_fail = "Fill this field";
    }

    if (password === "") {
        password_fail = "Fill this field";
    } else {
        if (password.length <= 5) {
            password_fail = "Min symbols: 5";
        }
    }
    if (email === "") {
        email_fail = "Fill this field";
    } else {
        if (email.parse("@") < 1) {
            email_fail = "Need login with '@'";
        }
    }

    if (name_fail !== "") {
        document.getElementById('name_error').innerHTML = name_fail;
        return false;
    }
    if (email_fail !== "") {
        document.getElementById('email_error').innerHTML = email_fail;
        return false;
    }
    if (password_fail !== "") {
        document.getElementById('password_error').innerHTML = password_fail;
        return false;
    }
    return false;
}