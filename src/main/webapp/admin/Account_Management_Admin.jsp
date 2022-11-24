<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Account Management</title>
<!-- Font Icon -->
<link rel="stylesheet"
	href="../fonts/css/material-design-iconic-font.min.css">
<!-- Main css -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link href="https://use.fontawesome.com/releases/v5.0.4/css/all.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
	
</script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js">
	
</script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link href="../css/style.css" rel="stylesheet">
</head>
<body>
	<div class="main">
		<!-- Sign in  Form -->
		<div class="container">
			<div class="signin-form">
				<h2 class="form-title">Account Management</h2>
				<form>
					<div class="form-group">
						<label for="fullname">Full Name: </label> <input type="text"
							id="fullname" name="fullname"> <label for="id">Student
							ID: </label> <input type="text" id="id" name="id"> <label
							for="birthday">Birthday: </label> <input type="text"
							id="birthday" name="birthday"> <label for="sex">Sex:
						</label> <input type="text" id="sex" name="sex"> <label
							for="academic_year">Academic Year: </label> <input type="text"
							id="academic_year" name="academic_year"> <input
							type='file' onchange="readURL(this);" />
						<!-- Nút nộp -->
						<span><input type="submit" name="update" id="update"
							class="form-submit" value="Update" /></span> <a
							href="Update_Account_User.jsp" class="button"> <span
							class="form-submit">Cancel</span></a> <img
							style="max-height: 300px; margin-left: 60px; margin-bottom: 60px; margin-top: 60px;"
							id="blah" src="../images/trang.jpg" alt="your image"
							align="right" />
					</div>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function readURL(input) {
			if (input.files && input.files[0]) {
				var reader = new FileReader();

				reader.onload = function(e) {
					$('#blah').attr('src', e.target.result);
				};
				reader.readAsDataURL(input.files[0]);
			}
		}
	</script>

</body>
</html>