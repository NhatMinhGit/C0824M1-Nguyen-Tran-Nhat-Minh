<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Currency Converter</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h2>Currency Converter</h2>
<form action="/display-discount" method="post">
    <label>Product Description: </label><br/>
    <input type="text" name="product_description" placeholder="note"/><br/>
    <label>Price: </label><br/>
    <input type="number" name="price" placeholder="VND" value="0"/><br/>
    <label>Discount Percent: </label><br/>
    <input type="number" name="percent" placeholder="VND" value="0"/><br/>
    <input type = "submit" id = "submit" value = "Converter"/>
</form>
</body>
</html>