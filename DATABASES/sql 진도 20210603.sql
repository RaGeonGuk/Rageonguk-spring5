--DESC: Description ���̺����� ����
DESC dept;
--select: ���̺��� ��ȸ, where ��ȸ����, as(Alias)��Ī���� �ʵ���� �涧
--concat����Ŭ�����Լ��� ����Ʈ �ۼ��� 
SELECT 
concat(deptno,' ��') as "�μ���ȣ"
, dname as "�μ���" 
, concat(loc, ' ��') as "��ġ"
FROM dept 
WHERE loc = 'NEW YORK';
--DUAL ���� ���̺� �̸�, ���̺��� ���� ������ select �Ҷ�
--SELECT concat('��','�Ǳ�') from dual;
SELECT 3+5 as "3���ϱ�8��" from dual;
-- ���ڵ�(row): �÷�(�ʵ�field)��� ����
SELECT concat(count(*),'��') as"������ 2000�� ����" FROM emp WHERE sal > 2000;
-- ū ����ǥ(�ʵ��), ���� ����ǥ(���� ó��, ��, ����)
SELECT * FROM emp WHERE ename != 'KING';
-- '!' ����ǥ�� ~�� �ƴѻ���� ���ϴ� ��
SELECT * FROM emp WHERE hiredate >= '1982/01/01';

-- OR�� +(������), AND�� X(������)
SELECT * FROM emp
WHERE deptno = 10 OR job ='MANAGER';

-- BETWEEN
SELECT * FROM emp WHERE sal
NOT BETWEEN 2000 AND 3000;

SELECT * FROM emp WHERE hiredate
BETWEEN '1980/01/01' AND '1980/12/31';
SELECT * FROM emp WHERE comm NOT IN (300,500,1400);

-- LIKE ��ȸ, ���ϵ�ī��=% ��ȸ
-- Ű���忡 ��ȣ�� ������ �Լ� upper(), concat(), count()
SELECT * FROM emp WHERE ename LIKE upper('k%');
SELECT * FROM emp WHERE ename LIKE '%N';

-- null(��) �� �߿��� ����: null ���� ������ �˻� �ȵ� (null�� 0�̳� ������ �ƴ�)
-- �׷���, null ���� �ʵ忡 ������, �˻� �����?
SELECT * FROM emp WHERE comm IS NULL;
-- NVL(Null VlaLue) null(��) ���� (��ġ)ó���ϴ� �Լ�
-- ����߿� Ŀ�̼��� 0�� ���� �����?
SELECT * FROM emp WHERE comm = 0;

-- ����߿� Ŀ�̼��� 0������ ����� null ���� �����?
-- �Ʒ� E�� emp ���̺��� �˸��ƽ� ��Ī���� E.* ������ emp.*�� ��������
SELECT nvl(comm,0), E.* FROM emp E WHERE NVL(comm,0) = 0;
-- ����Ŭ�� ǥ�� ����X ANSI ������ ǥ���Դϴ�.

-- NVL2 (�ʵ��, ���̾ƴҶ� 100, ���϶� 0), NVL(�ʵ��, ���϶� 0)
���� �ƴϸ� 0�� �ְ� ���̸� 100�� �־��
SELECT nvl2(comm,100,0), E.* FROM emp E WHERE NVL(comm,0) = 0;
-- DECODE�� NVL2�� ��������� �������̶� �� ����� DECODE(comm,null,�϶� '0',�ƴҶ� 'comm')
SELECT DECODE(comm,null,0,comm), nvl2(comm,100,0), E.* FROM emp E WHERE NVL(comm,0) = 0;

-- ���� sort = ���� order by �ʵ�� ��������[�ʱⰪ]ascending | ��������desending
-- ���� �������� ���� ���ּ���.
SELECT emp.sal, emp.* FROM emp ORDER BY emp.sal DESC; --��������
SELECT E.sal, E.* FROM emp E ORDER BY E.sal ASC; --�ø�����

-- ��������? (select ����� �ߺ��Ǿ� �ִ�...)�� �ʿ��� 
-- ���� 1���� �����ּ���.
SELECT ROWNUM, E.* FROM (--���̺��
SELECT * FROM emp ORDER BY sal DESC --��������
) E WHERE ROWNUM =1 ;
-- �� �������� ������ �ؼ� �� ���� ���� ���ʺ��� �ؼ��մϴ�.
-- �� ���Ŀ��� 1� ���� limit�� mysql(������DB)�� ��ɾ�. ����Ŭ X
-- mysql(������DB)�� �ִ� AI(AutoIncrement) �ڵ������� ��� ����ŬX 

-- �ߺ����ڵ� (row)�� �����ϴ� ��ɾ� distinct
SELECT * FROM emp;
--�μ���ȣ ���ϴ� ���
SELECT deptno as "�μ���ȣ" FROM emp; -- �������� �μ���ȣ�� ���
-- �ߺ��Ǵ� �μ���ȣ ����� ���
SELECT DISTINCT deptno as "�μ���ȣ" FROM emp;

-- ���ڿ��� �����Ҷ� CONCAT �Լ� �ܿ� || ���������� 2���� ��ó�� ����
SELECT ename || 'is a'|| job AS "���ڿ� ����" FROM emp;

--������� SELECT ������ Read
-- ���Ŀ��� CRUD �߿� Isert, Update, Delete
