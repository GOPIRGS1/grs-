function sendMail() {
    let params = {
        name: document.getElementById("name").value,
        email: document.getElementById("email").value,
        subject: document.getElementById("subject").value,
        message: document.getElementById("message").value,
    };

    emailjs.send("service_vlspxrt", "template_ugh7buc", params)
        .then(function(response) {
            alert("Email sent successfully!");
            document.getElementById("contact-form").reset(); // Optional: Reset the form after sending
        }, function(error) {
            alert("Failed to send email. Please try again later.");
        });
}
