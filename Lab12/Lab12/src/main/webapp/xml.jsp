<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "x" uri = "http://java.sun.com/jsp/jstl/xml" %>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="styles/tableStyle.css"/>
    <title>XML tags</title>
</head>
<body>
<c:import var = "productsInfo" url = "products.xml" charEncoding="UTF-8"/>
<x:parse xml = "${productsInfo}" var = "output"/>

<table>
  <tr>
    <th>Название</th>
    <th>Артикул</th>
    <th>Металл</th>
    <th>Вес (г)</th>
    <th>Вставка</th>
    <th>Цена (со скидкой)</th>
    <th>Цена (без скидки)</th>
  </tr>
  <x:forEach select="$output/products_list/rings" var="item">
    <tr>
      <td><x:out select="$item/name"/></td>
      <td><x:out select="$item/item_number"/></td>
      <td><x:out select="$item/metal"/></td>
      <td><x:out select="$item/weight"/></td>
      <td><x:out select="$item/insert"/></td>
      <td><x:out select="$item/price"/></td>
      <td><x:out select="$item/old_price"/></td>
    </tr>
  </x:forEach>
</table>


</body>
</html>
