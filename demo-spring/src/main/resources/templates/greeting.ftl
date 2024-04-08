<html lang="en">
<head>
    <title>${title}</title>
</head>
<body>
<h2>Greeting Form</h2>
<form method="get">
    <table>
        <tr>
            <td><label for="lang">Greeting Formula</label></td>
            <td>
                <select name="lang" id="lang">
                    <#list greetings as greeting>
                        <option value=${greeting.lang()}>${greeting.langText()}</option>
                    </#list>
                </select>
            </td>
        </tr>
        <tr>
            <td><label for="name">Your Name</label> </td>
            <td><input type="text" id="name" name="name"> </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" value="Submit" formaction="/greetings/hello">
            </td>
        </tr>
    </table>
</form>
</body>
</html>