import os
import re
from string import digits
def rename_files():
    #(1) get file names from a folder
    file_list = os.listdir(r"/Users/karlkyeongankwon/Documents/Screenshots/temp")
    print(file_list)
    save_path = os.getcwd()
    os.chdir(r"/Users/karlkyeongankwon/Documents/Screenshots/temp")
    

    #(2) for each file, rename filename
    for filename in file_list:
        print("Old name" + filename)
        print("New name" + re.sub("[0-9.-]","",filename))
        os.rename(filename, re.sub("[0-9.-]","",filename))

    os.chdir(save_path)
        


rename_files()
