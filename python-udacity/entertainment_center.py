import fresh_tomatoes
import media

terminator_2 = media.Movie("Terminator 2",
                        "Terminator 2: Judgment Day",
                        "http://t1.gstatic.com/images?q=tbn:ANd9GcS5J6Ay6y1UT7WAI4U7Zm2KDYITrvfOI3vmaCNdGhx_0jmWiI1d",
                        "https://www.youtube.com/watch?v=eajuMYNYtuY")

matrix = media.Movie("The Matrix",
                    "The Matrix",
                    "http://ia.media-imdb.com/images/M/MV5BMTkxNDYxOTA4M15BMl5BanBnXkFtZTgwNTk0NzQxMTE@._V1_UX182_CR0,0,182,268_AL_.jpg",
                    "https://www.youtube.com/watch?v=oZ1-M8O70zk")

inception = media.Movie("Inception",
                    "Inception",
                    "http://t2.gstatic.com/images?q=tbn:ANd9GcRo9vfJCM6dzPkZHIHBVCtlJnAnew9Ai26kEdrli0-tfmatmciD",
                    "https://www.youtube.com/watch?v=66TuSJo4dZM")

movies = [terminator_2, matrix, inception]
fresh_tomatoes.open_movies_page(movies)
print(media.Movie.VALID_RATINGS)
