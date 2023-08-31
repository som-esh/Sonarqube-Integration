<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="ISO-8859-1">
        <title>Minor Assignment 1</title>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">

        <script type="text/javascript">
            function get_action() {
                var v = document.querySelector('input[name="selection"]:checked').value;
 
                var res = "add"
                if (v == "sub") res = "sub";
                else if (v == "mul") res = "mul";
                else if (v == "div") res = "div";
                else if (v == "mod") res = "mod";
					
               // var t1 = document.getElementById("t1").value
               // var t2 = document.getElementById("t2").value
               // var test = "add"+"/"+t1+"/"+t2
               // console.log(test)
               
               console.log(res);
               
                document.getElementById("myform").action = res;
                document.getElementById("myform").submit();
            }
        </script>

    </head>

    <body>
        <div class="container">
            <div class="row">
                <div>
                    <h1>Calculator</h1>
	            <h4>(Production Environment)</h4>
                </div>
                <form action="add" name="myform" id="myform">
                    <div>
                        <label>Num1</label>
                        <input type="text" id="t1" class="form-control" name="t1">
                    </div>
                    <div>
                        <label>Num2</label>
                        <input type="text" id="t2" class="form-control" name="t2">
                    </div> </br>

                    <div class="form-check">
                        <input type="radio" class="form-check-input" name="selection" id="add" value="add" checked="checked">Addition<br>
                        <input type="radio" class="form-check-input" name="selection" id="sub" value="sub" >Subtraction<br>
                        <input type="radio" class="form-check-input" name="selection" id="mul" value="mul">Multiplication<br>
                        <input type="radio" class="form-check-input" name="selection" id="div" value="div">Division<br>
                        <input type="radio" class="form-check-input" name="selection" id="mod" value="mod">Modulus<br>
                    </div>
                    <div>
                        <input onClick=get_action() type="submit" value="Go" class="btn btn-outline-primary px-2 py-6 my-4">
                    </div>
                </form>
            </div>
        </div>
    </body>

    </html>
