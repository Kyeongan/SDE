def read_text():
    quotes = open("/Users/karlkyeongankwon/git/SDE/python-udacity/movie_quotes.txt")
    contents_of_file = quotes.read()
    print(contents_of_file)
    quotes.close()

read_text()
