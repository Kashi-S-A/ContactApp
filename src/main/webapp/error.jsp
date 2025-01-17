<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Session Expired</title>
    <style>
        /* Basic Reset */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        /* Full page setup */
        body, html {
            height: 100%;
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            display: flex;
            justify-content: center;
            align-items: center;
            margin: 0;
        }

        .error-container {
            text-align: center;
            padding: 30px;
            border-radius: 8px;
            background-color: #ffffff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 100%;
        }

        .error-message h1 {
            font-size: 2.5rem;
            color: #e74c3c;
            margin-bottom: 10px;
        }

        .error-message p {
            font-size: 1rem;
            color: #555;
            margin-bottom: 20px;
        }

        .error-message a.btn {
            display: inline-block;
            padding: 10px 20px;
            background-color: #3498db;
            color: white;
            font-size: 1rem;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s;
        }

        .error-message a.btn:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>
    <div class="error-container">
        <div class="error-message">
            <h1>Session Expired</h1>
            <p>Your session has expired.</p>
            <p>Please log in again to continue.</p>
            <a href="login" class="btn">Login Again</a>
        </div>
    </div>
</body>
</html>
