<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PPP Airlines</title>
<link rel="stylsheet" href="resources/css/bootstrap-reboot.css" />
</head>
<body>
	<h2>Welcome Aboard with PPP Airlines!</h2>
	<h3>Καλώς ορίσατε!</h3>

	<div class="container">
		<div class="title">Πρόσθεσε Επιβάτη</div>

		<form action="AddPassenger" method="post">
			<fieldset>
				<div class="inputFields">
					<label for="first-name" class="inputLabel">Όνομα: </label> <input
						name="first-name" type="text"></input>
				</div>
				<div class="inputFields">
					<label for="last-name" class="inputLabel">Επώνυμο: </label> <input
						name="last-name" type="text"></input>
				</div>
				<div class="inputFields">
					<label for="dob" class="inputLabel">Ημερομηνία Γέννησης: </label> <input
						name="dob" type="text"></input>
				</div>
				<div class="inputFields">
					<label for="gender" class="inputLabel">Φύλλο: </label> <select
						name="gender">
						<option value="Male">Άνδρας</option>
						<option value="Female">Γυναίκα</option>
					</select>
				</div>
			</fieldset>
			<div class="inputField" id="submitField">
				<input id="submitBtn" type="submit" value="Προσθήκη νέου επιβάτη"></input>
			</div>
		</form>

	</div>
</body>
</html>