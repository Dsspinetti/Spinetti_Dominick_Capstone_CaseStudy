function validate() {
    if (document.myForm.firstName.value == "") {
        alert("Please provide your first name!");
        document.myForm.firstName.focus();
        return false;
    } else {
        let FIRST_NAME = document.getElementById("firstName").value;
    }
      if (document.myForm.lastName.value == "") {
            alert("Please provide your last name!");
            document.myForm.lastName.focus();
            return false;
        } else {
            let LAST_NAME = document.getElementById("lastName").value;
        }


    if (document.myForm.email.value == "") {
        alert("Please provide your Email!");
        document.myForm.email.focus();
        return false;
    }
    if (document.myForm.email.value != "") {
        if (validateEmail()) {
            let emailValue = document.getElementById("email").value;
        }
    }

    if (document.myForm.password.value == "") {
        alert("Please provide your password");
        document.myForm.password.focus();
        return false;
    } else {
        var pass = document.getElementById("password").value;
        alert("First Name: " + FIRST_NAME + ",Last Name: " + LAST_NAME + ", Password: " + pass + ", Email: " + emailValue);
        return true;
    }
}

function validateEmail() {
    var emailID = document.myForm.email.value;
    atpos = email.indexOf("@");
    //alert(atpos)
    dotpos = email.lastIndexOf(".");
    if (atpos < 1 || (dotpos - atpos < 2)) {
        alert("Please enter correct email ID")
        document.myForm.email.focus();
        return false;
    } else {
        return true;
    }
    return (true)
}
let element = document.getElementById("survey-form");
if (element.addEventListener) {
    element.addEventListener("submit", main_validator, true);
}
else if (ele.attachEvent) {
    element.attachEvent('onsubmit', main_validator)
}

function main_validator(e) {
    console.log(e);
    e.preventDefault();
    ele.innerHTML = "";
    if (check_username(e.target[0].value) &&
        check_dob(e.target[1].value)
    ) {
        element.submit();
    }
}

function check_username(username) {
    let re = new RegExp(/^[a-zA-Z0-9_.-]*$[a-zA-Z_.-]*$/);
    let message = "";
    let someWrong = false;
    console.log(re.test(username));
        if (!re.test(username)) {
            message += "username can only be [a-z], [A-Z], or (-,_)";
            someWrong = true;
        }
        if (username.length > 20) {
            message += "username must be less than 20 characters";
            someWrong = true;
        }
        if (someWrong) {
            let para = document.createElement("P");
            para.classList.add("danger");
            let t = document.createTextNode(message);
            para.appendChild(t);
            ele.appendChild(para);
            return false;
        }
        return true;
}