


<!DOCTYPE html>
<html>
<head>
  <title>Registration Page</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
 <link rel="stylesheet" href="signin.css">
</head>
<body>
  <div class="container">
    <div class="register-form">
      <h2>Login</h2>
      <form  action="LoginServlet" method="post">
        
        <div class="form-group">
          <label for="email" class="form-label"style ="color : gray ;">Email or Mobile:</label>
          <input type="text" name="useremail" class="form-control" id="email" required>
        </div>
        
        <div class="form-group">
          <label for="password" class="form-label"style ="color : gray ;">Password:</label>
          <input type="password" name="userpassword"class="form-control" id="password" required>
        </div>
        
        <button type="submit" class="btn btn-primary" >Login</button>
        <p class="form-text text-center">Don't have an account? <a href="index.html" class="register-link">Sign up</a></p>
      </form>
    </div>
  </div>
<!--
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

  <script>
  $(document).ready(function() {
    $('#loginForm').submit(function(event) {
      event.preventDefault(); // Prevent the default form submission behavior

      // Get the form data
      var formData = {
        contact: $('#email').val(),
        password: $('#password').val()
      };

      // Send the form data using AJAX
      $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/serve/LoginServlet', // Replace with the actual URL of your servlet
        data: formData,
        success: function(response) {
          // Handle the response from the server (e.g., redirect to a new page)
          window.location.href = 'temporary.jsp'; // Replace with the URL of the welcome page
        },
        error: function(xhr, status, error) {
          // Handle the error (e.g., display an error message)
          alert('Login failed. Please try again.');
        }
      });
    });
  });
</script> 
-->

    
    
    
    
</body>
</html>
