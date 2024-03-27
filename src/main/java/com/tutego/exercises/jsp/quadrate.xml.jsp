<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="1.2">
<jsp:directive.page contentType="text/xml" />
<?xml version="1.0" encoding="UTF-8"?>
<quadratzahlen>
  <jsp:scriptlet>
  <![CDATA[ 
    for (int i = 0; i < 10; i++) {
   ]]>  
   </jsp:scriptlet>
  <quadratpaar>
    <zahl><jsp:expression>i</jsp:expression></zahl>
    <quadrat><jsp:expression>i*i</jsp:expression></quadrat>
  </quadratpaar>
  <jsp:scriptlet>
  <![CDATA[ 
    }
  ]]>  
  </jsp:scriptlet>
</quadratzahlen>

</jsp:root>