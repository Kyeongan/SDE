/*-----------------------------------------------
*	Program Information
*
*	Class Name : UNiX Programming
*	Prof. : Park, TaeSoon
*
*	Dept. Of Software Engineering
*	Name   : Kwon, Kyeong-An
*	Email  : newmkka@korea.com
*
*	Desc   : Line Editor
*                 - Using System Call
*
*	Expire : 2005-05-02 -> 2005-05-09
*	Last Updated : 2005-04-30
*                      2005-05-09
------------------------------------------------*/


/*-----------------------------------------------
*	Include Header File
------------------------------------------------*/
#include <stdio.h>
#include <malloc.h>
#include <unistd.h>
#include <fcntl.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <ctype.h>
#include <memory.h>


/*-----------------------------------------------
*	Macro definition
------------------------------------------------*/
#define	MAXCHARS	80
#define SIZE		512
#define	TRUE		1
#define FALSE		0
#define CAPITAL(x)	((x)-32)


/*-----------------------------------------------
*	Data Structure - LinkedList
------------------------------------------------*/
typedef struct stackNode
{
	char data[MAXCHARS+1];
	struct stackNode *next;
}stackNode;


/*-----------------------------------------------
*	Function Prototype
------------------------------------------------*/
int cmdParse(void);
int FileOK(char *);
int overSize(char *);
int countList(stackNode *);

void exitProgram(int);
void errMsg(char *msg);
void showMenu(stackNode *, char *);

stackNode* createList(void);
stackNode* addData(stackNode *);
stackNode* delData(stackNode *);
stackNode* showList(stackNode *);
stackNode* changeData(stackNode *);
stackNode* loadFile(stackNode*, char *);
stackNode* fileSave(stackNode *, char *);


/*-----------------------------------------------
*	Grobal Variable
------------------------------------------------*/
const char *cmdMenu = "COMMAND> (I)nput, (D)elete, (C)hange, (L)ist, (S)ave, (Q)uit\n*";
const char *cmdI = "Usage : I n";
const char *cmdN = " n";
const char *cmdM = " n-m";

char cmd='\0';
char cmd2='\0';
int n=1, m=1;
int argNum=0;
int nm=1;


/*-----------------------------------------------
*	Main Function
------------------------------------------------*/
main(int argc, char **argv)
{
	char cmdBuf[10];
	int n=0, m=0;
	char loop=0;
	char buf[SIZE];
	char filename[20];
	ssize_t nread;
	int i;

	argNum = argc;
	stackNode *head = NULL;

	if( argc>3 )
	{
		printf("Usage : %s <filename>\n", argv[0]);
		fflush(stdout);
		exitProgram(9);
	}
	else if( argc==1 )
	{
		while(TRUE)
		{
			printf("Enter filename : ");
			fflush(stdout);

			memset(buf, '\0', SIZE);
			memset(filename, '\0', 20);

			if( (nread=read(0, buf, 10)) == -1 )
			{
				errMsg("READ");
				exit(1);
			}

			if( nread!=1 )
				break;;
		}

		for( i=0 ; i<20 ; i++ )
		{
			if( buf[i]=='\n' )
				break;
			filename[i] = buf[i];
		}

		head = createList();
		if( FileOK(filename) )
		{
			head = loadFile(head, filename);
			showMenu(head, filename);
		}
		// there is no file.
		else
			// show Command Menu
			showMenu(head, filename);
	}
	else if( argc==2 )
	{
		head = createList();

		if( FileOK(argv[1]) )
		{
			head = loadFile(head, argv[1]);
			showMenu(head, argv[1]);
		}
		// there is no file.
		else
			// show Command Menu
			showMenu(head, argv[1]);
	}

	exitProgram(1);
}


/*-----------------------------------------------
*	showMenu Function
*       - to show menu to user.
------------------------------------------------*/
void showMenu(stackNode *head, char *filename)
{
	while(1)
	{
		write(1, cmdMenu, strlen(cmdMenu));
		//Command Parse
		if( cmdParse()==FALSE )
			continue;

		switch(cmd)
		{
			case 'Q':
				exitProgram(2);
				break;
			case 'L':
				head = showList(head);
				break;
			case 'I':
				head = addData(head);
				break;
			case 'D':
				head = delData(head);
				break;
			case 'C':
				head = changeData(head);
				break;
			case 'S':
				if( cmd2=='A' )
				{
					fileSave(head, filename);
					exitProgram(3);
				}
				else
					head = fileSave(head, filename);
				break;
			default:
				continue;
		}
	} // while for program

	return;
}


/*-----------------------------------------------
*	cmdParse Function
*       - to parse what user inputs.
------------------------------------------------*/
int cmdParse(void)
{
	char cmdBuf[20];
	char *p;
	int tmp[20], cnt=1;
	ssize_t nread;
	int fd;
	int i=0;

	cmd = 0;
	nm=1;

	memset(cmdBuf, '\0', 20);
	memset(tmp, 999, 20);

	if( read(0, cmdBuf, 19) == -1 )
		errMsg("READ");

	p = cmdBuf;
	cmd = cmdBuf[0];

	if( islower(cmd) != 0 )
		cmd = CAPITAL(cmd);

	if( cmd=='\n' )
	{
		n=1;
		m=1;
		return FALSE;
	}

	// Only press 'Q' to exit.
	if( cmd=='Q' )
	{
		for( i=2 ; i<20 ; i++ )
		{
			if( cmdBuf[i]!='\0' )
				return FALSE;
		}
		if( cmdBuf[1] == '\n' )
			return TRUE;
	}

	// Only press 'S' to save.
	if( cmd=='S' )
	{
		if( CAPITAL(cmdBuf[1]) == 'Q' )
		{
			for( i=3 ; i<20 ; i++ )
			{
				if( cmdBuf[i]!='\0' )
					return FALSE;
			}
			cmd2 = 'A';
			return TRUE;
		}
		else
		{
			for( i=2 ; i<20 ; i++ )
			{
				if( cmdBuf[i]!='\0' )
					return FALSE;
			}
			if( cmdBuf[1] == '\n' )
				return TRUE;
		}
	}

	if( cmd=='I' )
	{
		if( cmdBuf[1]=='\n' )
		{
			printf("%s\n", cmdI);
			fflush(stdout);
			return FALSE;
		}

		for( i=1 ; i<20 ; i++ )
		{
			if( cmdBuf[i]==' ' && cmdBuf[i+1]=='\n' || cmdBuf[i]=='-' )
			{
				printf("%s\n", cmdI);
				fflush(stdout);
				return FALSE;
			}
		}

		for( i=1 ; i<20 ; i++ )
		{
			if( cmdBuf[i]>='0' && cmdBuf[i]<='9' )
			{
				tmp[cnt] = atoi(&(cmdBuf[i]));
				cnt++;
				while( (cmdBuf[i]>='0' && cmdBuf[i]<='9') )
					i++;
			}
		}

		if( cnt>2 )
		{
			printf("%s\n", cmdI);
			fflush(stdout);
			return FALSE;
		}
		cnt--;
		n = tmp[cnt];
		m = 1;
		return TRUE;
	}

	if( cmd=='D' || cmd=='C' || cmd=='L' )
	{
		if( cmdBuf[1]=='\n' )
		{
			printf("Usage : %c%s, %c%s\n", cmd, cmdN, cmd, cmdM);
			fflush(stdout);
			return FALSE;
		}

		for( i=1 ; i<20 ; i++ )
		{
			if( cmdBuf[i]==' ' && cmdBuf[i+1]=='\n' )
			{
				printf("Usage : %c%s, %c%s\n", cmd, cmdN, cmd, cmdM);
				fflush(stdout);
				return FALSE;
			}
		}

		for( i=1 ; i<20 ; i++ )
		{
			if( cmdBuf[i]>='0' && cmdBuf[i]<='9' )
			{
				tmp[cnt] = atoi(&(cmdBuf[i]));
				cnt++;

				while( (cmdBuf[i]>='0' && cmdBuf[i]<='9') )
					i++;
			}
			if( cmdBuf[i]=='-' )
				nm=2;
		}

		if( cnt>3 )
		{
			printf("Usage : %c%s, %c%s\n", cmd, cmdN, cmd, cmdM);
			fflush(stdout);
			return FALSE;
		}

		if( cnt>2 )
		{
			if( tmp[1] >= tmp[2] )
			{
				errMsg("Not Collect Number");
				return FALSE;
			}
		}

		if( nm==1 )
		{
			n = tmp[1];
			m = 1;
		}
		else if( nm==2 )
		{
			n = tmp[1];
			m = tmp[2];
		}

		return TRUE;
	}

#if 0
	if( cmd=='I' || cmd=='D' || cmd=='C' || cmd=='L'  )
	{
		if( cmdBuf[1] == '\n' || (cmdBuf[1] == ' ' && cmdBuf[2] == '\n') || (cmdBuf[1]<'0' && cmdBuf[1]>'9') )
			return FALSE;
		else
		{
			while( (*p)!=0 )
			{
				p++;
				if( (*p)==' ' || (*p)=='-' )
					continue;

				else if( (*p)>='0' && (*p)<='9' )
				{
					tmp[cnt] = atoi(p);
					printf("tmp[%d] : %d\n", cnt, tmp[cnt]);
					while( (*p)>='0' && (*p)<='9' )
						p++;
					cnt++;
				}
			}
		}

		n = tmp[0];
		m = tmp[1];

		if( cmd=='I' )
			m=0;
	}
	else
	{
		n=0, m=0;
		return FALSE;
	}
#endif
	return TRUE;
}


/*-----------------------------------------------
*	FileOK Function
*       - to check whether file is or not.
------------------------------------------------*/
int FileOK(char *filename)
{
	if( access(filename, F_OK) == -1 )
		return FALSE;
	else
		return TRUE;
}


/*-----------------------------------------------
*	overSize Function
*       - to slice char which is over 80.
------------------------------------------------*/
int overSize(char *buf)
{
	if( strlen(buf) > 80 )
	{
		// implementation
	}
}


/*-----------------------------------------------
*	createList Function
*       - to make linkedList and initial.
------------------------------------------------*/
stackNode* createList(void)
{
	stackNode *head;
	int i=0;

	head = (stackNode*)malloc(sizeof(stackNode));
	head->next = NULL;
	memset(head->data, '\0', MAXCHARS+1);

	return head;
}


/*-----------------------------------------------
*	addData Function
*       - to insert data to list.
------------------------------------------------*/
stackNode* addData(stackNode *head)
{
	stackNode *new;
	stackNode *newHead;
	stackNode *p;
	stackNode *pp;

	char buf[SIZE];

	ssize_t nread;
	int insertPos=100;
	int i=0, j=0, pos=0;
	int cnt;
	int loop=TRUE;

	char buf2[MAXCHARS];
	int overI=0;
	int overJ=0;

	cnt = countList(head);

	if( cnt==0 )
	{
		n = 1;
		insertPos = 100;
	}
	else if( n==0 )
	{
		n = 1;
		insertPos = 1;
	}
	else if( (cnt!=0) && (n==1) )
	{
		n = 1;
		insertPos = 1;
	}
	else if( (cnt!=0) && (cnt<n) )
	{
		n = cnt+1;
		insertPos = 100;
	}
	else if( (cnt!=0) && (cnt>=n) )
		insertPos = 50;

	while(1)
	{
		printf("%6d: ", n++);
		fflush(stdout);
		fflush(stdin);

		memset(buf, '\0', SIZE);
		if( (nread=read(0, buf, SIZE)) == -1 )
		{
			errMsg("READ");
			return;
		}

		// Go to Command Mode, Check <enter><enter>
		if( nread==1 )
			break;

		p = head;


/*-----------------------------------------------------------*/
		// Slice Char
		if( nread>80 )
		{
			while( nread!=0 )
			{
				memset(buf2, '\0', MAXCHARS);

				for( overI=0 ; overI<79 ; overI++ )
				{
					buf2[overI] = buf[overJ++];
					if( buf2[overI]=='\n' )
						break;
				}

//				buf2[overI]='\0';

				new = (stackNode*)malloc(sizeof(stackNode));
//				memset(new->data, '\0', MAXCHARS+1);
				strcpy(new->data, buf2);
				new->next = NULL;

				p = head;

				if( head->next == NULL )
					head->next = new;
				else
				{
					while( p->next != NULL )
						p = p->next;
					p->next = new;
				}
				nread = nread - strlen(buf2);
			}
			return head;
		}

/*-----------------------------------------------------------*/

		if( j<1 )
		{
			pp = head;
			j++;
		}

		if( insertPos == 100 )
		{
			new = (stackNode*)malloc(sizeof(stackNode));
			strcpy(new->data, buf);
			new->next = NULL;

			if( head->next == NULL )
				head->next = new;
			else
			{
				while( p->next != NULL )
					p = p->next;
				p->next = new;
			}
		}
		else if( insertPos == 1 )
		{
			new = (stackNode*)malloc(sizeof(stackNode));
			strcpy(new->data, buf);
			new->next = NULL;

			new->next = pp->next;
			pp->next = new;
			pp = new;
		}
		else if( insertPos == 50 )
		{
			new = (stackNode*)malloc(sizeof(stackNode));
			strcpy(new->data, buf);

			if( j==1 )
			{
				for( pos=1 ; pos<(n-1) ; pos++ )
					pp = pp->next;
				j++;
			}

			new->next = pp->next;
			pp->next = new;
			pp = pp->next;

/*			for( pos=1 ; pos<(n-1) ; pos++ )
				pp = pp->next;

			new->next = pp->next;
			pp->next = new;
			pp = new;
*/
		}
	}//while loop
	return head;
}


/*-----------------------------------------------
*	changedData Function
*       - to change data from list.
------------------------------------------------*/
stackNode* changeData(stackNode *head)
{
	stackNode *p;
	stackNode *modData;

	size_t nread;
	char buf[SIZE];
	int i=0;
	int cnt;
	int cnt2=n;
	int times=0;

	cnt = countList(head);
	if( (cnt==0) || (n==0) )
	{
		errMsg("There is no Line");
		return head;
	}
	else if( (cnt!=0) && (cnt<n) || (cnt<m) )
	{
		errMsg("LineOver");
		return head;
	}

	showList(head);
	printf("   ->You can change.\n");
	fflush(stdout);

	if( nm==1 )
	{
		p = head;
		for( i=0 ; i<n ; i++ )
			p = p->next;

		memset(buf, '\0', SIZE);
		printf("%6d: ", cnt2++);
		fflush(stdout);

		if( (nread=read(0, buf, SIZE)) == -1 )
		{
			errMsg("READ");
			return head;
		}
		if( nread==1 )
			return head;
		strcpy(p->data, buf);
		return head;
	}

	if( nm==2 )
	{
		p = head;

		for( i=0 ; i<n ; i++ )
			p = p->next;

		for( times=1 ; times<=((m-n)+1) ; times++ )
		{
			memset(buf, '\0', SIZE);
			printf("%6d: ", cnt2++);
			fflush(stdout);

			if( (nread=read(0, buf, SIZE)) == -1 )
			{
				errMsg("READ");
				return head;
			}

			// Go to Command Mode, Check <enter><enter>
			if( nread==1 )
				break;

			strcpy(p->data, buf);
			p = p->next;
		}
		return head;
	}
}


/*-----------------------------------------------
*	delData Function
*       - to delete data from list.
------------------------------------------------*/
stackNode* delData(stackNode *head)
{
	stackNode *p;
	stackNode *del;

	int i=1, cnt=0;
	int times=0;

	cnt = countList(head);

	if( head->next==NULL )
	{
		errMsg("Empty List");
		return head;
	}
	else
	{
		p = head;
		if( n==0 )
		{
			errMsg("There is no 0 Line");
			return head;
		}
		else if( n>cnt || m>cnt )
		{
			errMsg("LineOver");
			return head;
		}
		else
		{
			if( nm==1 )
			{
				while( i < n )
				{
					p = p->next;
					i++;
				}
				del = p->next;
				p->next = p->next->next;
				free(del);
			}
			else if( nm==2 )
			{
				for( times=1 ; times<=((m-n)+1) ; times++ )
				{
					while( i < n )
					{
						p = p->next;
						i++;
					}
					del = p->next;
					p->next = p->next->next;
					free(del);
				}
			}

		}
	}

	return head;
}


/*-----------------------------------------------
*	countList Function
*       - to count total list.
------------------------------------------------*/
int countList(stackNode *head)
{
	stackNode *p;
	int cnt=0;
	p = head;

	while( p->next!=NULL )
	{
		p = p->next;
		cnt++;
	}
//	printf("[ %d ]", cnt);
	fflush(stdout);
	return cnt;
}


/*-----------------------------------------------
*	showList Function
*       - to show list to screen.
------------------------------------------------*/
stackNode* showList(stackNode *head)
{
	stackNode *p;

	int i;
	int cnt=1;
	int cnt2=0;
	int times=0;

#if 0
	if( n==0 )
	{
		if( (p = p->next) == NULL )
			printf("%6d: %s", cnt++, p->data);
		else
		{
			p = p->next;
			printf("%6d: %s", cnt++, p->data);
		}

//		for( cnt=0 ; cnt<=cnt2-1 ; cnt++ )
//			printf(p->data);

	}
	else if( n!=0 )
	{
	}

/*	while( cnt<2 )
	{
		printf("%6d: %s", cnt++, p->data);
		p = p->next;
	}
	return;*/
#endif

	cnt2=countList(head);
	p = head;

	if( n==0 )
	{
		while( (p = p->next) != NULL )
		{
			printf("%6d: %s", cnt++, p->data);
			fflush(stdout);
		}

		return head;
	}

	if( head->next == NULL )
	{
		errMsg("Empty List");
		return head;
	}

	if( (cnt2<n) || (cnt2<m) )
	{
		errMsg("Over Line");
		return head;
	}

	if( (0 < n <= cnt2) && (nm==2) )
	{
		cnt=n;
		for( i=0 ; i<n ; i++ )
			p = p->next;

		for( times=1 ; times<=((m-n)+1) ; times++ )
		{
			printf("%6d: %s", cnt, p->data);
			fflush(stdout);
			cnt++;
			p = p->next;
		}

		return head;
	}
	else if( n <= cnt2 )
	{
		cnt=n;
		for( i=0 ; i<n ; i++ )
			p = p->next;
		printf("%6d: %s", cnt, p->data);
		fflush(stdout);

		return head;
	}
}


/*-----------------------------------------------
*	fileSave Function
*       - to save file to disk.
------------------------------------------------*/
stackNode* fileSave(stackNode *head, char *filename)
{
	stackNode *p;
	int cnt;
	int fd;
	ssize_t nread;

	cnt = countList(head);
	if( cnt<0 )
	{
		errMsg("Never save! Empty List");
		return head;
	}
//	if( argNum==1 )
//	{
		if( (fd=open(filename, O_WRONLY | O_CREAT | O_TRUNC, 0644)) == -1 )
		{
			errMsg("OPEN");
			return head;
		}
		p = head->next;
		while( p != NULL )
		{
			write(fd, p->data, strlen(p->data));
			p = p->next;
		}

		printf("File Save Success..\n");
		fflush(stdout);
		return head;
//	}
//	else if( argNum==2 )
//	{
//		if( (
//
//		return head;
//	}
//	return head;
}


/*-----------------------------------------------
*	loadFile Function
*       - to load file which file is from disk.
------------------------------------------------*/
stackNode* loadFile(stackNode* head, char *filename)
{
	int fd;
	int loadSize=0;
	ssize_t nread;
	char buf[SIZE];
	char buf2[MAXCHARS];
	int i=0, j=0;
	char *find;

	stackNode *new;
	stackNode *p;

	if( (fd=open(filename, O_RDWR)) == -1 )
	{
		errMsg("loadFile Open");
		return head;
	}
	else
	{
		memset(buf, '\0', SIZE);
		if( (nread=read(fd, buf, SIZE)) == -1 )
		{
			errMsg("READ");
			return head;
		}
		find = buf;

		while( nread>0 )
		{
			memset(buf2, '\0', MAXCHARS);
			for( i=0 ; i<79 ; i++ )
			{
				buf2[i] = buf[j];
				j++;
				if( buf[j-1]=='\n' )
					break;
			}

			new = (stackNode*)malloc(sizeof(stackNode));
			strcpy(new->data, buf2);
			new->next;

			p = head;
			if( head->next == NULL )
				head->next = new;
			else
			{
				while( p->next != NULL )
					p = p->next;
				p->next = new;
			}
			nread = nread - strlen(buf2);
		}
		return head;
	}
}
#if 0
		while( (nread=read(fd, buf, MAXCHARS)) > 0 )
		{
			while( TRUE )
			{
				printf("buf[%d] %c\n",i, buf[i]);
				fflush(stdout);
				if( buf[i]=='\0' )
					break;
				i++;
				printf("i.. %d", i);
				fflush(stdout);
			}

			new = (stackNode*)malloc(sizeof(stackNode));
			strcpy(new->data, buf);
			new->next = NULL;

			p = head;
			if( head->next == NULL )
				head->next = new;
			else
			{
				while( p->next != NULL )
					p = p->next;
				p->next = new;
			}
			//free(new);
			memset(buf, '\0', SIZE);
		}
	}
	return head;
#endif


/*-----------------------------------------------
*	errMsg Function
*       - to show error message to screen.
------------------------------------------------*/
void errMsg(char *msg)
{
	perror(msg);
	return;
}


/*-----------------------------------------------
*	exitProgram Function
*       - to exit Program.
------------------------------------------------*/
void exitProgram(int status)
{
	printf("Exit Program..\n");
	fflush(stdout);
	exit(status);
}
