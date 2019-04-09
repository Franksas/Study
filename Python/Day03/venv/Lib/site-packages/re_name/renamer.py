import os
import argparse
import re


class Renamer:

    def __init__(self):
        self.currentPath = os.getcwd()
        # self.currentPath = '/Users/george/lll/'
        self.oldPatten = ''
        self.newPatten = ''
        self.updateFile = False
        self.extension = ''
        self.suffix = ''
        self.parser = argparse.ArgumentParser()
        self.parseInputs(self.parser)
        print('Working Path:' + self.currentPath)

    def update(self):
        files = list(filter(lambda x: os.path.isfile(os.path.join(
            self.currentPath, x)), os.listdir(self.currentPath)))
        if len(files) > 0 and self.extension:
            files = list(filter(lambda x: x.endswith(self.extension), files))
        totalFiles = len(files)
        if not self.updateFile:
            print('This is the preview for you to review the update....')
        print('\nTotal {0} files will be updated.\n'.format(totalFiles))
        index = 0
        if(totalFiles > 0):
            files.sort()
            for file in files:
                index = index + 1
                newfileName = re.sub(self.oldPatten, self.newPatten, file)
                toAppend = self.suffix
                if self.suffix:
                    if self.suffix == '#':
                        toAppend = '-' + str(index)
                    extPos = newfileName.rfind('.')
                    if extPos >= 0:
                        newfileName = "{0}{1}{2}".format(
                            newfileName[0:extPos], toAppend, newfileName[extPos:len(newfileName)])
                    else:
                        newfileName = newfileName + toAppend

                if self.updateFile:
                    os.rename(os.path.join(self.currentPath, file),
                              os.path.join(self.currentPath, newfileName))
                print(file, ' ----> ', newfileName)

    def parseInputs(self, parser):
        parser.add_argument("old", help="specify old patten to remove")
        parser.add_argument("new", help="specify new patten you wanted")
        parser.add_argument(
            "--ext", help="This will filter out files with other extentions")
        parser.add_argument("-f", "--file", action="store_true",
                            help="This will make changes on file(s).", default=False)
        parser.add_argument(
            "-s", "--suffix", help="Will append suffix. # stands for the sequence for file list")
        args = parser.parse_args()
        if(args.old):
            self.oldPatten = args.old.strip()
        if(args.new):
            self.newPatten = args.new.strip()
        if args.suffix:
            self.suffix = args.suffix.strip()
        self.updateFile = args.file
        if(args.ext):
            self.extension = '.' + args.ext.strip().strip('.')
        # if(self.oldPatten == "" or self.newPatten == ""):
        #     print("You haven't spcify valid parameters, use --help for usage")
        #     os._exit(1)
