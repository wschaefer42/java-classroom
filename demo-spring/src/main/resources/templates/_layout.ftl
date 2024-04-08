<#macro header>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <title>Articles</title>
        <link href="/css/common.css" rel="stylesheet" type="text/css">
    </head>
    <style>
        table, td, th {
            padding: 2px 5px;
            border: 1px solid;
            text-align: left;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }
    </style>
    <body style="text-align: left; font-family: sans-serif">
    <img src="/images/person.png" alt="Icon" width="70" height="70">
    <h1>Person Journal</h1>
    <p><i>Powered by Spring & Freemarker!</i></p>
    <hr>
    <#nested>
    <br>
    <a href="/persons">Back to the main page</a>
    </body>
    </html>
</#macro>