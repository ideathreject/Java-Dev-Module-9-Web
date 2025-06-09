# 🐱 HTTP Status Image Downloader

A simple Java console application that allows users to enter an HTTP status code and download the corresponding cat image from [https://http.cat](https://http.cat).

---

## 📦 Project Description

This project uses the **OkHttp** library to send HTTP requests and download images.

### Features:

- User input from the console
- Input format validation (e.g., letters are not allowed)
- Check if the image exists on the server
- Download the image and save it as `cat-<code>.jpg`
- Handles exceptions and prompts the user again in case of errors

---
