function validateForm()
{
    let isValid=true;
    let username=document.getElementById("username").value;
    let password=document.getElementById("password").value;
    let confirmPassword=document.getElementById("confirmPassword").value;
    let dob=document.getElementById("dob").value;
    let userError=document.getElementById("userError");
    let passError=document.getElementById("passError");
    let confirmPassError=document.getElementById("confirmPassError");
    let dobError=document.getElementById("dobError");
    userError.textContent="";
    passError.textContent="";
    confirmPassError.textContent="";
    dobError.textContent="";
    if(!username){
        userError.textContent="username is required";
        isValid=false;
    }
    if(!password){
        passError.textContent="Password is required";
        isValid=false;
    }
    else if(password.length<8){
        passError.textContent="atleast 8 characters required";
        isValid=false;
    }
    if(password && confirmPassword!==password){
        confirmPassError.textContent="passwords donot match";
        isValid=false;
    }
    if(!dob){
        dobError.textContent="DoB is required";
        isValid=false;
    }
    return isValid;
}