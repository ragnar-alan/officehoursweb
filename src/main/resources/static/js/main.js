$(document).ready(function() {

    $('#login-form-link').click(function(e) {
        $("#login-form").delay(100).fadeIn(100);
        $("#register-form").fadeOut(100);
        $('#register-form-link').removeClass('active');
        $(this).addClass('active');
        e.preventDefault();
    });

    $('#register-form-link').click(function(e) {
        $("#register-form").delay(100).fadeIn(100);
        $("#login-form").fadeOut(100);
        $('#login-form-link').removeClass('active');
        $(this).addClass('active');
        e.preventDefault();
    });

    function validateEmail($email) {
        var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
        return emailReg.test( $email );
    }

    $("#regEmail").on("keyup focusout",function(e) {
        emailAddressCheck();
    });

    function emailAddressCheck() {
        var emailaddress = $("#regEmail").val();
        if (!validateEmail(emailaddress) || emailaddress == "" || typeof emailaddress === "undefined") {
            $("#regEmail").parent().addClass("has-error").removeClass("has-success");
            $("#feedback-icon").addClass("glyphicon-warning-sign").removeClass("glyphicon-ok");
        } else {
            $("#regEmail").parent().addClass("has-success").removeClass("has-error");
            $("#feedback-icon").addClass("glyphicon-ok").removeClass("glyphicon-warning-sign");
        }}

    $("#regConfirm-password").on("keyup focusout",function(e) {
        isRegistrationPasswordMatch();
    });

    $("#regPassword").on("keyup focusout",function(e) {
        isRegistrationPasswordMatch();
    });

    function changeRegistrationPasswordFeedback(passwordElement, state) {
        if (state == true) {
            passwordElement.parent().addClass("has-success").removeClass("has-error");
            passwordElement.next("span").addClass("glyphicon-ok").removeClass("glyphicon-warning-sign");
        } else {
            passwordElement.parent().addClass("has-error").removeClass("has-success");
            passwordElement.next("span").addClass("glyphicon-warning-sign").removeClass("glyphicon-ok");
        }
    }

    function isRegistrationPasswordMatch() {
        var pass = $("#regPassword");
        var pass_conf = $("#regConfirm-password");

        if (isPasswordFieldEmpty(pass, pass_conf) || (pass.val() != pass_conf.val())) {
            changeRegistrationPasswordFeedback(pass, false);
            changeRegistrationPasswordFeedback(pass_conf, false);
        } else {
            changeRegistrationPasswordFeedback(pass, true);
            changeRegistrationPasswordFeedback(pass_conf, true);
        }
    }

    function isPasswordFieldEmpty(pass, pass_conf) {
        return pass.val() == "" || pass_conf.val() == "" || typeof pass === "undefined" || typeof pass_conf === "undefined";
    }

    function isRegistrationFormOk() {
        $("#register-form").children("div").each(function(e) {
            if (this.hasClass("has-error")) {
                return false;
            }
        });
    }

    $("#register-submit").on("click", function(e) {
        e.preventDefault();
        if (isRegistrationFormOk()) {
            this.submit();
        }
    })
});

